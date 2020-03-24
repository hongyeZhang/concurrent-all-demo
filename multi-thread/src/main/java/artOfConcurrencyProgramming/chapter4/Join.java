package artOfConcurrencyProgramming.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-13 15:48
 **/
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + " termiante");

    }


    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate");
        }
    }
}

