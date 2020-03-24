package com.zhq.create;

/**
 * @author : ZHQ
 * @date : 2020/1/9
 */
public class SecondSimpleThread implements Runnable{
    private String name;

    public SecondSimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name : " + name + " is running");
    }
}
