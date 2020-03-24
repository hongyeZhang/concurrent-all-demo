package com.zhq.queue;

import java.util.Queue;
import java.util.Random;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Producer extends Thread {
    private Queue queue;
    private int maxSize;

    public Producer(int maxSize, Queue queue, String name) {
        super(name);
        this.maxSize = maxSize;
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("queue is full, producer thread is waitting");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("producing value : " + i);
                queue.add(i);
            }
        }
    }
}
