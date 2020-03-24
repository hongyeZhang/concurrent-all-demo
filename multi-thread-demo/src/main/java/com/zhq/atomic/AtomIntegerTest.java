package com.zhq.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class AtomIntegerTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(MyThread.integer.get());
        System.out.println(MyThread.integer);


    }


    static class MyThread extends Thread {
        //        static AtomicInteger integer = new AtomicInteger(0);
        static Integer integer = 0;
        @Override
        public void run() {
            for (int i = 0; i < 100000; ++i) {
//                integer.getAndIncrement();
                integer++;
            }
        }
    }


}
