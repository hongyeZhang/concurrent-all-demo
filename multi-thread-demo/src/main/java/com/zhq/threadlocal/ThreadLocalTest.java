package com.zhq.threadlocal;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 3; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    add5ByThreadLocal();
                }
            });
            thread.start();
        }
    }

    private static void add5ByThreadLocal() {
        for (int i = 0; i < 5; ++i) {
            Integer integer = THREAD_LOCAL_NUM.get();
            integer++;
            THREAD_LOCAL_NUM.set(integer);
            System.out.println(Thread.currentThread().getName() + " : thread num = " + integer);
        }
    }

}
