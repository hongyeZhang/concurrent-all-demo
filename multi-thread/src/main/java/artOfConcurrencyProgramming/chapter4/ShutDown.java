package artOfConcurrencyProgramming.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-13 14:13
 **/
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread1 = new Thread(one, "CountThread");
        countThread1.start();
        TimeUnit.SECONDS.sleep(1);
        countThread1.interrupt();


    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
//            while (on && !Thread.currentThread().isInterrupted()) {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);

        }

        public void cancle() {
            on = false;
        }
    }



}
