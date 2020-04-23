package com.zhq.redbonus.method2;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class UserThread2 implements Runnable {
    private HongBao2 hongBao2;

    public UserThread2(HongBao2 hongBao2) {
        this.hongBao2 = hongBao2;
    }

    @Override
    public void run() {
        double money = hongBao2.getRandomMoney();
        if (money == 0) {
            System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了！");
        } else {
            System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
        }

    }
}

