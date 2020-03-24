package com.zhq.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class RunableTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(new MyThread("task-1"));
        Future<?> future = pool.submit(new MyThread("task-2"));

        try {
            if (future.get() == null) {
                System.out.println("任务完成");
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            System.out.println("捕获到了");
            System.out.println(e.getCause().getMessage());
        }
    }


    static class MyThread implements Runnable {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("inside " + name);
            throw new RuntimeException("RuntimeException from inside : " + name);
        }
    }
}
