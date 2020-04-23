package com.zhq.redbonus.method2;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class QiangHongBao {

    public static void main(String[] args) {

        HongBao2 hongBao2 = new HongBao2(8.1, 8);

        UserThread2 user2 = new UserThread2(hongBao2);
        for (int i = 0; i < 10; i++) {
            new Thread(user2).start();
        }
    }
}
