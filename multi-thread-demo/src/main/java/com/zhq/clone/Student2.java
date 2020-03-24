package com.zhq.clone;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class Student2 implements Cloneable {

    private int age;
    private String name;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 这一步返回的这个student2还只是一个浅克隆，
        Student2 student2 = (Student2) super.clone();
        //然后克隆的过程中获得这个克隆的student2，然后调用这个getTeacher这个方方法得到这个Teacher对象。然后实现克隆。在设置到这个student2中的Teacher。
        //这样实现了双层克隆使得那个teacher对象也得到了复制。
        student2.setTeacher((Teacher) student2.getTeacher().clone());
        //双层克隆使得那个teacher对象也得到了复制
        return student2;
    }

}
