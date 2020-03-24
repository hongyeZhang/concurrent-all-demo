package com.zhq.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class ThreadPoolTestThree {

    static ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);

    public static void main(String[] args) {
        test1();

    }


    public static void test1() {
        for (int i = 0; i < 3; ++i) {
            final int index = i;
            scheduledExecutor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " index : " + index);
                }
            }, 0, 1, TimeUnit.SECONDS);
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后");
        scheduledExecutor.shutdown();
    }



}
