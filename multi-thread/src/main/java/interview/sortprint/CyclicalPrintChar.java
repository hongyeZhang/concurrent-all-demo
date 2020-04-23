package interview.sortprint;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class CyclicalPrintChar {
    ReentrantLock lock;

    int times;

    int state;

    public CyclicalPrintChar(int times) {
        this.times = times;
        lock = new ReentrantLock();
    }

    public void printA() {
        print(0, "A");
    }

    public void printB() {
        print(1, "B");
    }

    public void printC() {
        print(2, "C");
    }

    public void print(int targetState, String name) {
        for (int i = 0; i < times;) {
            lock.lock();
            try {
                if (state % 3 == targetState) {
                    System.out.println(name);
                    state++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        CyclicalPrintChar cyclicalPrintChar = new CyclicalPrintChar(3);

        Thread thread1 = new Thread(cyclicalPrintChar::printA);
        Thread thread2 = new Thread(cyclicalPrintChar::printB);
        Thread thread3 = new Thread(cyclicalPrintChar::printC);

        thread1.start();
        thread2.start();
        thread3.start();



    }



}
