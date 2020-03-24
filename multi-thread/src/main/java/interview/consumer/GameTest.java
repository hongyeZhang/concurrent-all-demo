package interview.consumer;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class GameTest {
    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        AddAndReductGame addAndReductGame = new AddAndReductGame();
        AddOperation addOperation = new AddOperation(addAndReductGame);
        DeductOperation deductOperation = new DeductOperation(addAndReductGame);

        Thread t1 = new Thread(addOperation);
        Thread t2 = new Thread(deductOperation);

        t1.start();
        t2.start();

    }


    public static void test2() {
        AddAndReductGame addAndReductGame = new AddAndReductGame();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; ++i) {
                    addAndReductGame.increment();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; ++i) {
                    addAndReductGame.decrement();
                }

            }
        }, "B").start();
    }
}
