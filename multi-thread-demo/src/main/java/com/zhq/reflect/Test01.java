package com.zhq.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        String str = "java.lang.String";
        Class<?> clazz = Class.forName(str);
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
}
