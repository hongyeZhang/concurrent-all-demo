package interview.cycleprint.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class ShareData {
    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void printOne() {
        lock.lock();
        try {
            while (number == 1) {
                System.out.println(number);
                number = 2;
                condition.signalAll();
            }
            condition.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printTwo() {
        lock.lock();
        try {
            while (number == 2) {
                System.out.println(number);
                number = 3;
                condition.signalAll();
            }
            condition.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printThree() {
        lock.lock();
        try {
            while (number == 3) {
                System.out.println(number);
                number = 1;
                condition.signalAll();
            }
            condition.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
