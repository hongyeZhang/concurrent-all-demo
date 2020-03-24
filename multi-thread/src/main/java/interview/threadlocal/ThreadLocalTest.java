package interview.threadlocal;

/**
 * @author : ZHQ
 * @date : 2020/3/17
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + "'s initial value: " + threadLocal.get());
                    for (int j = 0; j < 10; j++) {
                        threadLocal.set(threadLocal.get() + j);
                    }
                    System.out.println(Thread.currentThread() + "'s last value: " + threadLocal.get());
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }
    }


}
