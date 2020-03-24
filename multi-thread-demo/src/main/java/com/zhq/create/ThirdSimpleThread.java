package com.zhq.create;

import java.util.concurrent.Callable;

/**
 * @author : ZHQ
 * @date : 2020/1/9
 */
public class ThirdSimpleThread implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; ++i) {
            sum += i;
        }
        return sum;
    }
}
