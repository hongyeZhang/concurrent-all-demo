package interview.singleton;

/**
 * @author : ZHQ
 * @date : 2020/3/17
 */
//Holder方式：延迟加载、不加锁、线程安全
public class SingletonPattern4 {

    private SingletonPattern4() {
        //do sth about init
    }

    //在静态内部类中，有SingletonPattern4的实例，并且直接被初始化
    private static class Holder {
        private static SingletonPattern4 instance = new SingletonPattern4();
    }

    //返回的是Holer的静态成员instance
    public static SingletonPattern4 getInstance() {
        //在SingletonPattern4中没有instance的静态成员，而是将其放到了静态内部类Holder之中，因此在
        //SingletonPattern4类的初始化中并不会创建Singleton(延迟加载)的实例，Holder中定义了
        //SingletonPattern4的静态变量，并且直接进行了初始化。当Holder被主动引用的时候会创建
        //SingletonPattern4的实例，SingletonPattern4实例的创建过程在Java程序编译时候由同步方法<clinit>()
        //方法执行，保证内存的可见性、JVM指令的顺序性和原子性。
        return Holder.instance;
    }
}

