package artOfConcurrencyProgramming.chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-14 20:17
 **/
public class AtomicIntegerArrayTest {

    static int[]              value = new int[] { 1, 2 };

    static AtomicIntegerArray ai    = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.addAndGet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
