package javaConcurrencyInPractice.Chapter8;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-12 19:00
 **/
public class ThreadTest1 {

    public static void main(String[] args) {
/*        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");

        t1.start();
        t2.start();*/

/*        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        System.out.println(Thread.currentThread().getName());*/



/*        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }*/

        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();


    }

    static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; ++i) {
                System.out.println("thread " + name + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

