package com.zhq.threadlocal;

public class ThreadLocalTest2 {
    private ThreadLocal<Integer> localNum = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 10;
        }
    };


    public void add5ByThreadLocal() {
        for (int i = 0; i < 5; ++i) {
            Integer integer = localNum.get();
            integer++;
            localNum.set(integer);
            System.out.println(Thread.currentThread().getName() + ": thread num = " + integer);
        }
    }


    public static void main(String[] args) {
        ThreadLocalTest2 threadLocalTest2 = new ThreadLocalTest2();
        for (int i = 0; i < 3; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocalTest2.add5ByThreadLocal();
                }
            });
            thread.start();
        }


    }




}
