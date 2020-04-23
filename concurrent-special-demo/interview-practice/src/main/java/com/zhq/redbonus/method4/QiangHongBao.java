package com.zhq.redbonus.method4;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class QiangHongBao {

    public static void main(String[] args) {
        HongBao4 hongBao4 = new HongBao4(29);

        UserThread4 user4 = new UserThread4(hongBao4);
        for (int i = 0; i < 10; i++) {
            new Thread(user4).start();
        }
    }
}
