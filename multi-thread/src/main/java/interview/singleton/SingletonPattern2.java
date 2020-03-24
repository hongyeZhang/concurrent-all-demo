package interview.singleton;

/**
 * @author : ZHQ
 * @date : 2020/3/17
 */
//使用synchronized的线程安全的懒汉式
public class SingletonPattern2 {
    private static SingletonPattern2 instance;

    private SingletonPattern2() {
        //do sth about init
    }
    //缺点：实际上只有一个线程是写的操作（获得monitor之后new一个instance），后面的线程因为因为已经创建了instance，就是相当于读的操作，但是read的操作还是加锁同步了（串行化了），效率较低
    public synchronized static SingletonPattern2 getInstance() {
        if(null == instance) {
            instance = new SingletonPattern2();
        }
        return SingletonPattern2.instance;
    }
}

