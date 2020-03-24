package com.zhq.state;

import java.text.SimpleDateFormat;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Service {

    public void msleep() {
        synchronized (this) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("sleep，当前时间： " + df.format(System.currentTimeMillis()));
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mwait() {
        synchronized (this) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("wait : 结束时间 : " + df.format(System.currentTimeMillis()));
        }
    }

}
