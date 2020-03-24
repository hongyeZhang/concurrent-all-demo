package interview.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author : ZHQ
 * @date : 2020/3/22
 */
public class ThreadPoolTest1 {

    static class TestThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            int i = new Random().nextInt(1000);
            TimeUnit.MILLISECONDS.sleep(i);
            System.out.println(i);
            return i;
        }
    }


    public static void main(String[] args) {

        ThreadFactory namedThreadFactory =
                        new ThreadFactoryBuilder().setNameFormat("zhq-test-runner-%d").build();

        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(10), namedThreadFactory);


        for (int i = 0; i < 20; i++) {
            Future<Integer> result = executorService.submit(new TestThread());
            try {
                Integer integer = result.get(100, TimeUnit.MILLISECONDS);
                System.out.println(integer + "i=" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Oh, time out, i = " + i);
            }
        }
//        executorService.shutdown();

    }
}
