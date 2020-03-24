package interview.singleton;

/**
 * 立即加载/"饿汉模式"
 */
public class SingletonPattern1 {

    /**
     * 饿汉式是线程安全的，因为虚拟机保证只会装载一次，使用的时候是已经加载初始化好的instance
     */
    private static final SingletonPattern1 INSTANCE = new SingletonPattern1();

    private SingletonPattern1() {
    }

    public static SingletonPattern1 getInstance() {
        return INSTANCE;
    }
}

