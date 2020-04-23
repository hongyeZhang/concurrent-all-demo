package com.zhq.redbonus.method1;

import java.util.Random;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class HongBao {
    private double total;// 总钱数

    private int totalVal; // 总钱数小数化整数

    private int count; //红包总数

    public HongBao(double total, int count) {
        this.totalVal = (int) (total * 100);//把总钱数化为整数
        this.count = count;
    }

    /**
     *
     * 抢红包时随机生成红包（规定总金额和数量）
     *
     * @return
     */
    public synchronized double getRandomMoney() {
        int val;//每个人分配到的金额*100
        //当剩下的每一个人只分到一分钱的时候
        if (count != 0 && totalVal / count == 1) {
            val = 1;
            totalVal = totalVal - val;
            count--;
            return val / 100.0;
        }

        if (count <= 0) {
            val = 0;
        } else if (count == 1) {
            val = totalVal;//如果是最后一个
        } else {
            int temp; //剩下的金额
            while (true) {
                // 随机生成当前金额的随机数 [0,totalVal/count-1),尽量平均一点
                val = new Random().nextInt(totalVal / count * 2);
                temp = totalVal - val;
                // 判断生成的金额大于0，且剩余的钱数够剩下人平分到0.01元

                if (temp * 1.0 / (count - 1) >= 1 && val > 0) {
                    //System.out.println("生成金额 ：" + val + "剩余金额 ：" + temp + "剩余人数 ：" + (count-1));
                    break;
                }
            }
            totalVal = totalVal - val;
        }
        count--;
        return val / 100.0;
    }
}
