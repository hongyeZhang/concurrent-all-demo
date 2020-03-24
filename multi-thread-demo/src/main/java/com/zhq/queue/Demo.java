package com.zhq.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("How to use wait and notify method in Java");
        System.out.println("Solving Producer Consumper Problem");

        Queue queue = new LinkedList();
        int maxSize = 10;
        Thread producer = new Producer(maxSize, queue, "producer");
        Thread consumer = new Consumer(maxSize, queue, "consumer");
        producer.start();
        consumer.start();
    }
}
