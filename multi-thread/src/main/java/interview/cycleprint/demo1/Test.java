package interview.cycleprint.demo1;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class Test {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; ++i) {
                    shareData.printOne();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; ++i) {
                    shareData.printTwo();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; ++i) {
                    shareData.printThree();
                }
            }
        }, "C").start();

    }
}
