package com.zhq.redbonus.method3;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class QiangHongBao {
    public static void main(String[] args) {

        HongBao3 hongBao3 = new HongBao3(9, 6);

        UserThread3 user3 = new UserThread3(hongBao3);
        for (int i = 0; i < 10; i++) {
            new Thread(user3).start();
        }
    }
}
