package interview.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class ProduceConsumeBlockingQueueDemo {

    public static void main(String[] args) {

        SharedData data = new SharedData(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                data.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            try {
                data.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.stop();
        System.out.println("停止");
    }
}


class SharedData {
    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public SharedData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void produce() throws InterruptedException {
        String data = null;
        boolean ret;
        while (FLAG) {
            data = "" + atomicInteger.incrementAndGet();
            ret = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (ret) {
                System.out.println(Thread.currentThread().getName() + "\t插入" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("生产结束，FLAG=false");
    }

    public void consume() throws InterruptedException {
        String ret = null;
        while (FLAG) {
            ret = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == ret || ret.equalsIgnoreCase("")) {
                System.out.println(FLAG = false);
                System.out.println(Thread.currentThread().getName() + "\t消费等待超时退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费" + ret + "成功");
        }
    }

    public void stop() {
        FLAG = false;
    }


}
