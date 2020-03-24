package com.zhq.clone;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class CloneTest2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setAge(40);
        teacher.setName("teacher zhang");

        Student2 student2 = new Student2();
        student2.setAge(14);
        student2.setName("lisi");
        student2.setTeacher(teacher);

        Student2 student3 = (Student2)student2.clone();
        //这里是深复制，所以这时候Student2中的teacher就是teacher这个对象的一个复制，就和student3是student2的一个复制
        //所以下面teacher.setName只是对他原来的这个对象更改，但是复制的那个并没有更改
        System.out.println(student3.getAge());
        System.out.println(student3.getName());
        System.out.println(student3.getTeacher().getAge());
        teacher.setName("teacher niesong");//不会又任何影响
        System.out.println(student3.getTeacher().getName());

    }
}
