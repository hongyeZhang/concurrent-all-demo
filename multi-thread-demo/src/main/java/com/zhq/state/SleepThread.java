package com.zhq.state;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class SleepThread implements Runnable {
    private Service service;

    public SleepThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.msleep();
    }
}
