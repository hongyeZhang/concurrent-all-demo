package Test1;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-01-29 19:00
 **/
public class Test1 {

    public static void main(String[] args) {

/*        Thread myThread = new Thread(new MyRun());
        myThread.start();*/

        Thread thread1 = new Thread(new Runnable() {
            private int i = 0;

            @Override
            public void run() {
                while (i < 20) {
                    System.out.println(i++);
                }
            }
        });
        System.out.println(thread1.getState());

        thread1.start();
    }
}
