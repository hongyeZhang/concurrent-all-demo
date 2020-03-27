package interview.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : ZHQ
 * @date : 2020/3/26
 */
public class SemaphoreTest2 {
    private static final Semaphore SEMAPHORE = new Semaphore(3);

    private static final int LIMIT = 1;


    static class MyThread extends Thread {

        String name;

        public MyThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {

            try {
                SEMAPHORE.acquire(LIMIT);
                TimeUnit.SECONDS.sleep(3);

                System.out.println(name + " enter!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SEMAPHORE.release(LIMIT);
            }

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread("thread1"));
        Thread thread2 = new Thread(new MyThread("thread2"));
        Thread thread3 = new Thread(new MyThread("thread3"));
        Thread thread4 = new Thread(new MyThread("thread4"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }




}
