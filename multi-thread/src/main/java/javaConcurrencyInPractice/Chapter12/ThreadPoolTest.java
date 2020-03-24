package javaConcurrencyInPractice.Chapter12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-14 15:16
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {

    }

    public static void testPoolExpansion() {
        int MAX_SIZE = 10;
        ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE);

        for (int i = 0; i < 10 * MAX_SIZE; ++i) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

}


