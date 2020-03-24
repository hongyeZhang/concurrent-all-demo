package com.zhq.create;

import java.util.concurrent.FutureTask;

/**
 * @author : ZHQ
 * @date : 2020/1/9
 */
public class CreateThreadDemo {
    public static void main(String[] args) throws Exception {
//        createTest1();
//        createTest2();
        createTest3();

    }

    public static void createTest1() {
        SimpleThread simpleThread1 = new SimpleThread("thread-1");
        SimpleThread simpleThread2 = new SimpleThread("thread-2");
        simpleThread1.start();
        simpleThread2.start();
    }


    public static void createTest2() {
        Thread thread1 = new Thread(new SecondSimpleThread("thread-1"));
        Thread thread2 = new Thread(new SecondSimpleThread("thread-2"));
        thread1.start();
        thread2.start();
    }

    public static void createTest3() throws Exception {
        ThirdSimpleThread thirdSimpleThread = new ThirdSimpleThread();
        FutureTask<Integer> task = new FutureTask<Integer>(thirdSimpleThread);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }





}
