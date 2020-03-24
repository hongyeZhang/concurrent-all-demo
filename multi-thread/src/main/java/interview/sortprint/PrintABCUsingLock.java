package interview.sortprint;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/3/19
 */
public class PrintABCUsingLock {

    private int times;

    private int state;

    private Lock lock = new ReentrantLock();

    PrintABCUsingLock(int times) {
        this.times = times;
    }

    public void printA() {
        print("A", 0);
    }

    public void printB() {
        print("B", 1);
    }

    public void printC() {
        print("C", 2);
    }

    private void print(String name, int targetState) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetState) {
                System.out.println(name);
                state++;
                i++;
            }
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        PrintABCUsingLock printABCUsingLock = new PrintABCUsingLock(10);
        Thread thread1 = new Thread(printABCUsingLock::printA);
        Thread thread2 = new Thread(printABCUsingLock::printB);
        Thread thread3 = new Thread(printABCUsingLock::printC);
        thread1.start();
        thread2.start();
        thread3.start();

    }




}
