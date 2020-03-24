package com.zhq.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class ThreadPoolTestFour {

    static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 3; ++i) {
            final int index = i;
            singleExecutor.submit(new Runnable() {
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
        singleExecutor.shutdown();
    }
}
