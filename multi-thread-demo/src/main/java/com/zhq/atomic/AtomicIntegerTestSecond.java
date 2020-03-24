package com.zhq.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class AtomicIntegerTestSecond {
    public static void main(String[] args) {
        AddOperation addOperation = new AddOperation();
        Thread thread1 = new Thread(addOperation);
        Thread thread2 = new Thread(addOperation);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(AddOperation.integer.get());
    }

    static class AddOperation implements Runnable {
        static AtomicInteger integer = new AtomicInteger(0);
        @Override
        public void run() {
            for (int i = 0; i < 100000; ++i) {
                integer.getAndIncrement();
            }
        }
    }
}
