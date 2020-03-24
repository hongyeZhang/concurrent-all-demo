package com.zhq.lock;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class DeadLock {
    public static void main(String[] args) {
        dead_lock();
    }

    public static void dead_lock() {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread1 :locked resource1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource2) {
                        System.out.println("Thread1 :locked resource2");
                    }
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread2 :locked resource2");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resource1) {
                        System.out.println("Thread2 :locked resource1");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
