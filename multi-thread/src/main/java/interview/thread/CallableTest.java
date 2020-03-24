package interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class CallableTest {
    public static void main(String[] args)
                    throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        Thread t = new Thread(task);
        t.start();

        // 同步等待
        try {
            System.out.println(task.get(2, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
                        System.out.println("time out ");
                        }
                        }
                        }


class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call callable");
        Thread.sleep(3000);
        return 2020;
    }
}
