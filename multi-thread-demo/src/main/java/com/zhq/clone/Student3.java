package com.zhq.clone;

import java.io.*;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Student3 implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
    private Teacher3 teacher3;

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

    public Teacher3 getTeacher3() {
        return teacher3;
    }

    public void setTeacher3(Teacher3 teacher3) {
        this.teacher3 = teacher3;
    }

    //使得序列化student3的时候也会将teacher序列化
    public Object deepCopt() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //将当前这个对象写到一个输出流当中，，因为这个对象的类实现了Serializable这个接口，所以在这个类中
        //有一个引用，这个引用如果实现了序列化，那么这个也会写到这个输出流当中

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
        //这个就是将流中的东西读出类，读到一个对象流当中，这样就可以返回这两个对象的东西，实现深克隆
    }
}
