package javaConcurrencyInPractice.Chapter10;

import java.util.Random;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-13 11:24
 **/
public class DemonstrateDeadLock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        final Random rdn = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];

        for(int i=0;i<accounts.length;i++){
            accounts[i] = new Account();
        }

        class TransferThread extends Thread{
            public void run(){
                for(int i=0;i<NUM_ITERATIONS;i++){
                    int fromAccount = rdn.nextInt(NUM_ACCOUNTS);
                    int toAccount = rdn.nextInt(NUM_ACCOUNTS);

                    TransMoney.transferMoney(accounts[fromAccount],accounts[toAccount],rdn.nextInt(1000));
                    System.out.println("fromAccount : " + accounts[fromAccount].getAccount());
                    System.out.println("toAccount : " + accounts[toAccount].getAccount());
                }
            }
        }

        for(int i=0;i<NUM_THREADS;i++){
            new TransferThread().start();
        }
    }
}

class Account {
    private long account;

    public Account(String user, long account) {
        this.account = account;
    }

    public Account() {
        super();
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void debit(long money){
        this.account -= money;
    }

    public void credit(long money){
        this.account += money;
    }
}

class TransMoney {
    private static final Object tieLock = new Object();
    public static void transferMoney(Account fromAccount,Account toAccount,long amount){
        synchronized (fromAccount){
            synchronized (toAccount){
                fromAccount.debit(amount);
                toAccount.credit(amount);
            }
        }
    }
}
