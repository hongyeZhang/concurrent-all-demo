package interview.sortprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/3/19
 */
public class PrintABCUsingLockCondition {
    private int times;
    private int state;

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    PrintABCUsingLockCondition(int times) {
        this.times = times;
    }


    public void print(String name, int targetState, Condition current, Condition next) {
        for (int i = 0; i < times; ++i) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    current.await();
                }
                System.out.println(name);
                state++;
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printA() {
        print("A", 0, conditionA, conditionB);
    }

    public void printB() {
        print("B", 1, conditionB, conditionC);
    }

    public void printC() {
        print("C", 2, conditionC, conditionA);
    }


    public static void main(String[] args) {
        PrintABCUsingLockCondition printABCUsingLockCondition = new PrintABCUsingLockCondition(10);
        Thread thread1 = new Thread(printABCUsingLockCondition::printA);
        Thread thread2 = new Thread(printABCUsingLockCondition::printB);
        Thread thread3 = new Thread(printABCUsingLockCondition::printC);

        thread1.start();
        thread2.start();
        thread3.start();


    }







}
