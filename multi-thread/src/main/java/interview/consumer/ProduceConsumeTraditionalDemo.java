package interview.consumer;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class ProduceConsumeTraditionalDemo {

    public static void main(String[] args) {
//        ShareData data = new ShareData();
        AddAndReductGame data = new AddAndReductGame();



        new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
