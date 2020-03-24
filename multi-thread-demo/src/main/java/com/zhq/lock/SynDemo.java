package com.zhq.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class SynDemo {

    public static void main(String[] args) {
        Runnable t1 = new MyThread();
        new Thread(t1, "t1").start();
        new Thread(t1, "t2").start();
    }


    static class MyThread implements Runnable {
        private Lock lock = new ReentrantLock();

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            } finally {
                lock.unlock();
            }
        }

    }


}
