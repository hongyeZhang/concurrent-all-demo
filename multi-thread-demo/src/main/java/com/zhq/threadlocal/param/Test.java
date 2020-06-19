package com.zhq.threadlocal.param;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        ThreadLocalParam00 threadLocalParam00 = new ThreadLocalParam00();

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 2; i++) {
            final Long id = (long) i;
            executorService.execute(() -> {
                threadLocalParam00.business01(id);
            });
        }
        executorService.shutdown();
    }
}
