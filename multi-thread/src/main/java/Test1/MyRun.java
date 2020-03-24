package Test1;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-01-29 18:59
 **/
public class MyRun implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        while (i < 20) {
            System.out.println(i++);
        }
    }
}
