package com.zhq.redbonus.method3;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class UserThread3 implements Runnable {
    private HongBao3 hongBao3;

    public UserThread3(HongBao3 hongBao3) {
        this.hongBao3 = hongBao3;
    }

    @Override
    public void run() {
        double money = hongBao3.getRandomMoney();
        if (money == 0) {
            System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了！");
        } else {
            System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
        }

    }
}
