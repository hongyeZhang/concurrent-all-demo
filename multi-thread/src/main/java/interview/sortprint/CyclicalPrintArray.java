package interview.sortprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZHQ
 * @date : 2020/4/11
 */
public class CyclicalPrintArray {
    private Lock lock = new ReentrantLock();
    private Condition conditionChar = lock.newCondition();
    private Condition conditionNum = lock.newCondition();
    int[] numArray;
    char[] charArray;
    int totalState;

    public CyclicalPrintArray(int[] numArray, char[] charArray) {
        this.numArray = numArray;
        this.charArray = charArray;
    }

    public void printNum() {
        for (int i = 0; i < numArray.length; ++i) {
            lock.lock();
            try {
                while (isOdd(totalState)) {
                    conditionNum.await();
                }
                System.out.println(numArray[i]);
                totalState++;
                conditionChar.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printChar() {
        for (int i = 0; i < charArray.length; ++i) {
            lock.lock();
            try {
                while (!isOdd(totalState)) {
                    conditionChar.await();
                }
                System.out.println(charArray[i]);
                totalState++;
                conditionNum.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] numArr = new int[] {1, 2, 3};
        char[] charArr = new char[] {'A', 'B', 'C'};
        CyclicalPrintArray cyclicalPrintArray = new CyclicalPrintArray(numArr, charArr);
        Thread thread1 = new Thread(cyclicalPrintArray::printNum);
        Thread thread2 = new Thread(cyclicalPrintArray::printChar);
        thread1.start();
        thread2.start();
    }







}
