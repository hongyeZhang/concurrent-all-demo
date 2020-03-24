package javaConcurrencyInPractice.Chapter8;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-12 19:50
 **/
public class RunnableTest1 {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}

class MyThread implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("ticket : " + ticket--);
            }
        }
    }
}


