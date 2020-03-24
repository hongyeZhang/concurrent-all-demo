package interview.cycleprint.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
class ShareData {
    private int number = 1;

    private Lock lock = new ReentrantLock();

    public void printA() {
        lock.lock();
        Condition conditionA = lock.newCondition();
        try {
            while (number != 1) {
                conditionA.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        Condition conditionB = lock.newCondition();
        try {
            while (number != 2) {
                conditionB.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        Condition conditionC = lock.newCondition();
        try {
            //判断
            while (number != 3) {
                conditionC.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            //通知
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(() -> data.printA(), "A").start();
        new Thread(() -> data.printB(), "B").start();
        new Thread(() -> data.printC(), "C").start();
    }
}
