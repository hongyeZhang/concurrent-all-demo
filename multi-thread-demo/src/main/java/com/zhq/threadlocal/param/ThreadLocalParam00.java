package com.zhq.threadlocal.param;

public class ThreadLocalParam00 {
    private ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();

    /**
     * 模拟业务方法1
     */
    public void business01(Long id) {
        System.out.println(Thread.currentThread().getName() + " business01 in");
        userInfoThreadLocal.set(new UserInfo(id,"zhq"));
        business02();
    }


    /**
     * 模拟业务方法2
     */
    private void business02() {
        UserInfo userInfo = userInfoThreadLocal.get();
        System.out.println(Thread.currentThread().getName() + " business02, " + userInfo);
    }



}
