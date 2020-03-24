package ThreadPoolTest;

import java.util.concurrent.*;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-11 18:31
 **/
public class Test1 {

    public static void main(String[] args) {

//        ExecutorService pool = Executors.newFixedThreadPool(2);
        ExecutorService pool = Executors.newCachedThreadPool();
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();




    }

    public static void test1() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int index = i;
            try {
                Thread.sleep(index*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    public static void test2() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 8; ++i) {
            final int index = i;

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("执行完毕");
        threadPool.shutdown();
    }

    public static void test3() {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
/*        for (int i = 0; i < 5; ++i) {
            threadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("delay 1 seconds");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, 1, TimeUnit.SECONDS);
        }*/

        threadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 second, every 3 second");
            }
        }, 1, 2, TimeUnit.SECONDS);

    }

    public static void test4() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }
    }

}
