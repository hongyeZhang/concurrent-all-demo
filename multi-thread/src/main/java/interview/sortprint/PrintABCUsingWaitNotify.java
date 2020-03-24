package interview.sortprint;

import java.util.concurrent.locks.Lock;

/**
 * @author : ZHQ
 * @date : 2020/3/19
 */
public class PrintABCUsingWaitNotify {
    private int times;

    private int state;

    private static final Object LOCK = new Object();

    PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }

    public void print(String name, int targetState) throws InterruptedException {
        for (int i = 0; i < times; ++i) {
            synchronized (LOCK) {
                while (state % 3 != targetState) {
                    LOCK.wait();
                }
                System.out.println(name);
                state++;
                LOCK.notifyAll();
            }
        }
    }

    public void printA() {
        try {
            print("A", 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            print("B", 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            print("C", 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABCUsingWaitNotify = new PrintABCUsingWaitNotify(3);
        Thread thread1 = new Thread(printABCUsingWaitNotify::printA);
        Thread thread2 = new Thread(printABCUsingWaitNotify::printB);
        Thread thread3 = new Thread(printABCUsingWaitNotify::printC);
        thread1.start();
        thread2.start();
        thread3.start();




    }






}
