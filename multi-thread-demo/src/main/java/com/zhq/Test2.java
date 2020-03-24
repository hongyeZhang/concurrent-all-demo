package com.zhq;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZHQ
 * @date : 2020/1/9
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The JVM exit success ... ");
            }
        }));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("i am runnning ...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("the main thread ready to exit ...");


    }
}
