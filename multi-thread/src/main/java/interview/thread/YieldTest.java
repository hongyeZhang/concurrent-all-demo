package interview.thread;

/**
 * @author : ZHQ
 * @date : 2020/3/17
 */
public class YieldTest extends Thread {

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            if (i == 3 || i == 10 || i == 50 || i == 70 || i == 80 || i == 90) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yt1 = new YieldTest("张三");
        YieldTest yt2 = new YieldTest("李四");
        yt1.start();
        yt2.start();
    }
}
