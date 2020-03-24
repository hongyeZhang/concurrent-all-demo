package com.zhq.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class ThreadPoolTestTwo {
    static ExecutorService cachedExecutor = Executors.newCachedThreadPool();


    public static void main(String[] args) {
        test1();

    }

    public static void test1() {
        for (int i = 0; i < 6; ++i) {
            final int index = i;
            cachedExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " index : " + index);
                }
            });
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");
        cachedExecutor.shutdown();
    }


}
