package interview.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : ZHQ
 * @date : 2020/3/28
 */
public class AtomicTest {
    private AtomicInteger num = new AtomicInteger(0);

    public void increment() {
        num.getAndIncrement();
    }

    public int getNum() {
        return num.intValue();
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicTest atomicTest = new AtomicTest();

        for (int i = 0; i < 10; ++i) {
            new Thread(()->{
                for (int j = 0; j < 1000; ++j) {
                    atomicTest.increment();
                }
            }).start();
        }

        Thread.sleep(3000);

        System.out.println(atomicTest.getNum());





    }

}
