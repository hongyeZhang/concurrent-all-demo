package interview.interrupt;

/**
 * @author : ZHQ
 * @date : 2020/3/18
 */
public class SecondThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("哥们，起床了");
        }
    }
}
