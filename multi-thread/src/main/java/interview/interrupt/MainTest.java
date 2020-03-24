package interview.interrupt;

/**
 * @author : ZHQ
 * @date : 2020/3/18
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        test2();

    }

    public static void test1() {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println(myThread.getState());
        myThread.interrupt();
        System.out.println(myThread.getState());

    }

    public static void test2() throws InterruptedException {
        Thread thread = new Thread(new SecondThread());
        thread.start();

        Thread.sleep(500);
        thread.interrupt();

        System.out.println("over");



    }


}
