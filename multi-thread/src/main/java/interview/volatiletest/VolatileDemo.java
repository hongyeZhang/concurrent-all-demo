package interview.volatiletest;

/**
 * @author : ZHQ
 * @date : 2020/3/15
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();

    }

    public static void test1() throws InterruptedException {
        MyData myData = new MyData();
        for (int i = 0; i < 20; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; ++j) {
                        myData.addOne();
                    }
                }
            }, "thread-" + i).start();
        }

//        Thread.sleep(5000);
        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(myData.number);


    }

}
