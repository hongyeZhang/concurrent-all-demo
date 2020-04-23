package com.zhq.redbonus.method3;

import java.util.Random;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class HongBao3 {

    private double total;// 总钱数

    private int totalVal; // 总钱数小数化整数

    private int ceilVal;//红包最高额度*100 取整


    public HongBao3(double total, int ceilVal) {
        this.totalVal = (int) (total * 100);//把总钱数化为整数
        this.ceilVal = ceilVal * 100;
    }

    /**
     * 知道总金额，不确定红包数,总金额发完即止
     *
     * @return
     */
    public synchronized double getRandomMoney() {
        int val;//每个人分配到的金额*100
        // 随机生成当前金额的随机数 [0,ceilVal)
        val = new Random().nextInt(ceilVal);
        // 判断生成的金额等于0，便发0.01元
        if (val == 0) {
            val = 1;
        } else if (val > totalVal) {
            val = totalVal;
        }
        totalVal = totalVal - val;
        return val / 100.0;
    }
}
