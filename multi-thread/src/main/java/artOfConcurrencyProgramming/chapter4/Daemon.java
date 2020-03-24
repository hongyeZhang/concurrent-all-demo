package artOfConcurrencyProgramming.chapter4;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-13 11:48
 **/
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();

    }


    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("hello world");
                SleepUtils.second(10);
            } finally {
                System.out.println("finally run");
            }
        }
    }


}
