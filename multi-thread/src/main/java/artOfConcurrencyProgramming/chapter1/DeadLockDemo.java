package artOfConcurrencyProgramming.chapter1;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-09 20:46
 **/
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        // TODO: 2019/7/9   why???
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                        System.out.println("2");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
