package com.zhq.redbonus.method1;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class UserThread implements Runnable{
    private HongBao hongBao;

    public UserThread(HongBao hongBao) {
        this.hongBao = hongBao;
    }

    @Override
    public void run() {
        double money = hongBao.getRandomMoney();
        if(money == 0) {
            System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了！");
        }else {
            System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
        }

    }
}
