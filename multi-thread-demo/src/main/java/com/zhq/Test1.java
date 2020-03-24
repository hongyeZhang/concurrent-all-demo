package com.zhq;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZHQ
 * @date : 2020/1/9
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("i am running ...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("the main thread ready to exit ...");
    }

}
