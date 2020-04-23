package com.zhq.redbonus.method4;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class UserThread4 implements Runnable {
    private HongBao4 hongBao4;

    public UserThread4(HongBao4 hongBao4) {
        this.hongBao4 = hongBao4;
    }

    @Override
    public void run() {
        double money = hongBao4.getRandomMoney();
        System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
    }
}

