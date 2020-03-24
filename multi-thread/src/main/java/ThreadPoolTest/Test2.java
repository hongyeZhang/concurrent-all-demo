package ThreadPoolTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-03-05 23:29
 **/
public class Test2 {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

/*        for (int i = 0; i < 10; ++i) {
            final int index = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("正在执行task " + index);

                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task " + index + "执行完毕");
                }
            });

            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }*/
        long startTime = System.currentTimeMillis();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务一执行开始");
                    Thread.currentThread().sleep(2000);
                    System.out.println("任务一执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务2执行开始");
                    Thread.currentThread().sleep(4000);
                    System.out.println("任务2执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        long endTime = System.currentTimeMillis();
        System.out.println("执行时间为：" + (endTime - startTime)/1000);








    }
}
