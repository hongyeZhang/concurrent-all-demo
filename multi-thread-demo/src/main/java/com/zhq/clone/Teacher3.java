package com.zhq.clone;

import java.io.Serializable;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Teacher3 implements Serializable {

    //  上面的那个警告可以直接消除，除了使用在设置中不显示这个警告，还可以使用下面的这两条语句中的任何一条语句
//	这个serialVersionUID为了让该类别Serializable向后兼容
//	private static final long serialVersionUID = 1L;
//	private static final long serialVersionUID = 8940196742313994740L;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
