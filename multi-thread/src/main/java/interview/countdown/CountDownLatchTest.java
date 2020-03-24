package interview.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : ZHQ
 * @date : 2020/3/17
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; ++i) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("thread1");
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread over");
        executorService.shutdown();
    }
}
