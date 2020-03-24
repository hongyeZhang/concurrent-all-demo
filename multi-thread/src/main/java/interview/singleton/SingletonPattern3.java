package interview.singleton;

/**
 * @author : ZHQ
 * @date : 2020/3/17
 */
//double check + volatile的方式
public class SingletonPattern3 {

    //volatile禁止指令重排序(happens-before中有一条volatile变量规则：对一个volatile变量的写的操作先行发生与对这个变量的读操作)
    private volatile static SingletonPattern3 instance;

    //SingletonPattern3其他的一些引用类型的属性PropertyXXX  propertyxxx;

    private SingletonPattern3() {
        //do sth about init
    }

    public static SingletonPattern3 getInstance() {
        if (null == instance) {
            synchronized (SingletonPattern3.class) {
                if(null == instance) {
                    //instance = new SingletonPattern3();这句，这里看起来是一句话，但实际上它并不是一个原
                    //子操作，在被编译后在JVM执行的对应汇编代码做了大致3件事情：
                    //(1)分配内存
                    //(2)调用构造器
                    //(3)将instance对象指向分配的内存空间首地址(这时候的instance不为null)
                    //但由于指令重排序(Java编译器允许处理器乱序执行)的存在，上面三个步骤可能是1-2-3也可能是
                    //1-3-2，注意，如果是1-3-2的情况就可能出现问题，我们来分析一下可能出现的问题：
                    //I：假设现在两个线程thread1、thread2，现在threa1获取到monitor，然后按照上面的1-3-2执行，
                    //II：假设在3执行完毕、2未执行之前(或者说2只执行一部分，SingletonPattern3中的引用类型
                    //的属性一部分还是null)，这个时候切换到thread2上，
                    //III：这时候instance因为已经在thread1内执行过了(3)，instance已经是非空了，所以
                    //thread2直接拿走instance，然后使用，但是实际上instance指向的内存地址并没有调用构造器
                    //初始化的，这就可能会出现问题了。
                    instance = new SingletonPattern3();
                }
            }
        }
        return SingletonPattern3.instance;
    }
}

