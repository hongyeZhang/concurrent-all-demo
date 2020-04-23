package com.zhq.redbonus.method1;

/**
 * @author : ZHQ
 * @date : 2020/4/23
 */
public class QiangHongBao {

    public static void main(String[] args) {

        HongBao hongBao = new HongBao(8.1, 8);
        UserThread user = new UserThread(hongBao);
        for (int i = 0; i < 10; i++) {
            new Thread(user).start();
        }
    }
}
