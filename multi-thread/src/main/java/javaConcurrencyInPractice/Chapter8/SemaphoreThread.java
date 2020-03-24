package javaConcurrencyInPractice.Chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: multi-thread
 * @description: 信号量的使用
 * @author: ZHQ
 * @create: 2019-02-12 09:59
 **/
// TODO: 2019/2/12     这个例子写的跟shit一样，有错误。
public class SemaphoreThread {
    private volatile int a = 0;

    /**
     * 银行存钱类
     */
    class Bank {
        private int account = 100;

        public int getAccount() {
            return account;
        }

        public void save(int money) {
            account += money;
        }
    }

    /**
     * 线程执行类，每次存10块钱
     */
    class NewThread implements Runnable {
        private Bank bank;
        private Semaphore semaphore;

        public NewThread(Bank bank, Semaphore semaphore) {
            this.bank = bank;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            int b = a++;
/*            if (semaphore.availablePermits() > 0) {
                System.out.println("线程" + b + "启动，进入银行,有位置立即去存钱");
            } else {
                System.out.println("线程" + b + "启动，进入银行,无位置，去排队等待等待");
            }*/
            try {
                semaphore.acquire();
                System.out.println("线程" + b + "启动，进入银行,有位置去存钱");
                bank.save(10);
                System.out.println(b + "账户余额为：" + bank.getAccount());
                Thread.sleep(1000);
                System.out.println("线程" + b + "存钱完毕，离开银行");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 建立线程，调用内部类，开始存钱
     */
    public void useThread() {
        Bank bank = new Bank();
        // 定义2个新号量
        Semaphore semaphore = new Semaphore(2);
        // 建立一个缓存线程池
        ExecutorService es = Executors.newCachedThreadPool();
        // 建立20个线程
        for (int i = 0; i < 20; i++) {
            // 执行一个线程
            es.submit(new Thread(new NewThread(bank, semaphore)));
        }
        // 关闭线程池
        System.out.println("关闭线程命令之前");
        es.shutdown();
        System.out.println("关闭线程命令之后");

        // 从信号量中获取两个许可，并且在获得许可之前，一直将线程阻塞
        semaphore.acquireUninterruptibly(2);
        System.out.println("到点了，工作人员要吃饭了");
        // 释放两个许可，并将其返回给信号量
        semaphore.release(2);
        System.out.println("吃完饭了");
    }

    public static void main(String[] args) {
        SemaphoreThread test = new SemaphoreThread();
        test.useThread();
    }
}
