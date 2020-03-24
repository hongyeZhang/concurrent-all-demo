package artOfConcurrencyProgramming.chapter8;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-14 20:30
 **/
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }

}
