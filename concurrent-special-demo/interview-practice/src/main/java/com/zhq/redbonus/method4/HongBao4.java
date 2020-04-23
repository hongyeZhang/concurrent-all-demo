package com.zhq.redbonus.method4;

import java.util.Random;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class HongBao4 {
    private int ceilVal;//红包最高额度*100 取整


    public HongBao4(double ceil) {
        this.ceilVal = (int) ceil * 100;

    }

    /**
     *  总金额不限,红包限额，红包数不限，有多少人抢发多少个
     *
     * @return
     */
    public synchronized double getRandomMoney() {
        int val;//每个人分配到的金额*100
        val = new Random().nextInt(ceilVal);
        return val / 100.0;
    }
}
