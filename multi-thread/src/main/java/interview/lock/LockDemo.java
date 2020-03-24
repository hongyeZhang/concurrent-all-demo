package interview.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/3/18
 */
public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }


}
