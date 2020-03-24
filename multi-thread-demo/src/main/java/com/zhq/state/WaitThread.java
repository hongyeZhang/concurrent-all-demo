package com.zhq.state;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class WaitThread implements Runnable {

    private Service service;

    public WaitThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.mwait();
    }
}
