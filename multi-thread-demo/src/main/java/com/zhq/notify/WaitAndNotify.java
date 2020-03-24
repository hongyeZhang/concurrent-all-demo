package com.zhq.notify;

import java.rmi.Naming;
import java.util.concurrent.TimeUnit;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o);

        for (int i = 0; i < 5; ++i) {
            MyThread t = new MyThread("thread " + i, o);
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("main thread notify");
            synchronized (o) {
                o.notifyAll();
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("main thread is end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    static class MyThread extends Thread {
        private String name;
        private Object target;

        public MyThread(String name, Object target) {
            this.name = name;
            this.target = target;
        }

        @Override
        public void run() {
            System.out.println(name + " is waiting ...");
            try {
                synchronized (target) {
                    target.wait();
                }
                System.out.println(name + " has been notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
