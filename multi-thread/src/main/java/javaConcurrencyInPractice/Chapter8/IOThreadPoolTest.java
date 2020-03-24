package javaConcurrencyInPractice.Chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-12 22:09
 **/
public class IOThreadPoolTest {

    // 使用无限线程数的CacheThreadPool线程池
    static ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    static List<Callable<Object>> tasks;

    // 仍然是5000个任务
    static int taskNum = 5000;

    static {
        tasks = new ArrayList<>(taskNum);
        for (int i = 0; i < taskNum; i++) {
            tasks.add(Executors.callable(new IOTask()));
        }
    }

    static class IOTask implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        cachedThreadPool.invokeAll(tasks);// warm up all thread
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        testExecutor(cachedThreadPool, tasks);
        // 看看执行过程中创建了多少个线程
        int largestPoolSize = cachedThreadPool.getLargestPoolSize();
        System.out.println("largestPoolSize:" + largestPoolSize);
        cachedThreadPool.shutdown();
    }

/*    private static void testExecutor(ExecutorService executor, List<Callable<Object>> tasks)
            throws InterruptedException {
        long start = System.currentTimeMillis();
        executor.invokeAll(tasks);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }*/

}
