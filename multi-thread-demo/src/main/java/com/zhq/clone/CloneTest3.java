package com.zhq.clone;

/**
 * @author : ZHQ
 * @date : 2020/1/11
 */
public class CloneTest3 {
    public static void main(String[] args) throws Exception {
        Teacher3 teacher3 = new Teacher3();
        teacher3.setAge(23);
        teacher3.setName("niesong");

        Student3 student3 = new Student3();
        student3.setAge(50);
        student3.setName("wutao");
        student3.setTeacher3(teacher3);

        Student3 ss = (Student3) student3.deepCopt();
        System.out.println(ss.getAge());
        System.out.println(ss.getName());

        System.out.println("---------------------");
        System.out.println(ss.getTeacher3().getAge());
        System.out.println(ss.getTeacher3().getName());

        System.out.println("-----------------------");

        ss.getTeacher3().setAge(7777);
        ss.getTeacher3().setName("hhhhh");

        System.out.println(teacher3.getAge());
        System.out.println(teacher3.getName());
        //虽然上面的已经改了，但是改的是那个复制对象后的那个里面的，然后那个原来的那个里面的并没有改，下面验证：：：

        System.out.println("-----------------");

        System.out.println(ss.getTeacher3().getAge());
        System.out.println(ss.getTeacher3().getName());


    }
}
