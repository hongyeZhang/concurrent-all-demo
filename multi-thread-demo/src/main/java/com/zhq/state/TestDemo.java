package com.zhq.state;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class TestDemo {

    public static void main(String[] args) {
        test2();

    }

    public static void test1() {
        Service service = new Service();
        Thread sleepThread = new Thread(new SleepThread(service));
        Thread waitThread = new Thread(new WaitThread(service));
        sleepThread.start();
        waitThread.start();
    }

    public static void test2() {
        Service service = new Service();
        Thread sleepThread = new Thread(new SleepThread(service));
        Thread waitThread = new Thread(new WaitThread(service));
        waitThread.start();
        sleepThread.start();
    }






}
