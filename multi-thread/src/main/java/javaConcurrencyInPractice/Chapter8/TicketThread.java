package javaConcurrencyInPractice.Chapter8;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-12 20:07
 **/
public class TicketThread {

    public static void main(String[] args) {

        TicketThread ticketThread = new TicketThread();
        MyThread1 t1 = ticketThread.new MyThread1("线程1");
        MyThread1 t2 = ticketThread.new MyThread1("线程2");
        MyThread1 t3 = ticketThread.new MyThread1("线程3");
        t1.start();
        t2.start();
        t3.start();

/*        //创建了3个线程，模拟三个窗口卖票
        MyThread1 mt1 = new MyThread1("线程一");
        MyThread1 mt2 = new MyThread1("线程二");
        MyThread1 mt3 = new MyThread1("线程三");

        //启动线程
        mt1.start();
        mt2.start();
        mt3.start();*/
    }

    private class MyThread1 extends Thread {
        private int num = 5;//模拟还剩余5张票
        private String name;//用来表示线程名称

        public MyThread1(String name){
            this.name = name;
        }

        @Override
        public void run() {
            while(num > 0){
                num--;
                System.out.println(name+"卖出了一张票，剩余票数为"+num);
            }
        }
    }



}






