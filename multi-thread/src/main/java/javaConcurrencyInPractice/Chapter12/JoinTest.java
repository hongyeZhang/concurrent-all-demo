package javaConcurrencyInPractice.Chapter12;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-14 11:08
 **/
public class JoinTest {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.start();
    }
}

class Child extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("子线程运行开始。。。");
            Thread.sleep(1000);
            System.out.println("子线程运行结束....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Parent extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("父线程运行开始....");
            Child child = new Child();
            child.start();
            child.join();
            System.out.println("父线程运行结束....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
