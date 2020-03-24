package com.zhq.queue;

import java.util.Queue;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Consumer extends Thread {
    private int maxSize;
    private Queue queue;

    public Consumer(int maxSize, Queue queue, String name) {
        super(name);
        this.maxSize = maxSize;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("queue is empty, consumer thread is waiting");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consuming value : " + queue.remove());
            }
        }


    }
}
