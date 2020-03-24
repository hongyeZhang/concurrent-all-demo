package com.zhq.create;

/**
 * @author : ZHQ
 * @date : 2020/1/9
 */
public class SimpleThread extends Thread {

    public SimpleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("name : " + getName() + " is running ...");
    }
}
