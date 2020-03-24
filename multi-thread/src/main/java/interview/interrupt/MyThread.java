package interview.interrupt;

/**
 * @author : ZHQ
 * @date : 2020/3/18
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("hello world");
        }
    }
}
