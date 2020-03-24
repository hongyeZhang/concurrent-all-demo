package javaConcurrencyInPractice.Chapter7;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-11 18:39
 **/
public class Test {

    public static void main(String[] args) {
        final int index = 0;

        for (int i = 0; i < 10; ++i) {
            System.out.println(index);
        }
    }
}
