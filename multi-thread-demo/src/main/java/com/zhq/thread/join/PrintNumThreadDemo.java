package com.zhq.thread.join;

/**
 *  多线程循环有序打印数字
 * @author : ZHQ
 * @date : 2020/2/14
 */
public class PrintNumThreadDemo {
    static class PrintNumThread extends Thread{
        Thread previous;

        int printNum;

        PrintNumThread(Thread previous, int printNum) {
            super("thread-" + printNum);
            this.previous = previous;
            this.printNum = printNum;
        }

        @Override
        public void run() {
            super.run();
            try {
                previous.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(printNum);
        }
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; ++i) {
            PrintNumThread printNumThread = new PrintNumThread(previousThread, i);
            printNumThread.start();
            previousThread = printNumThread;
        }
    }


}
