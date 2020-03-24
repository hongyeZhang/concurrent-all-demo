package javaConcurrencyInPractice.Chapter12;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-14 10:52
 **/
public class BoundedBufferTest {

    public static void main(String[] args) {
//        testBasic();
        testInterrupt();

    }


    public static void testBasic() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        System.out.println(bb.isEmpty());
        System.out.println(bb.isFull());
    }

    public static void testInterrupt() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);

        Thread taker = new Thread(){
            @Override
            public void run() {
                try {
                    int used = bb.take();
                    System.out.println("如果执行到这里就失败了。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            taker.start();
            Thread.sleep(2000);
            taker.interrupt();
//            taker.join(1000);
            Thread.sleep(3000);
            System.out.println("线程还活着吗？ " + taker.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
