package javaConcurrencyInPractice.Chapter10;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-13 09:34
 **/
public class Test1 {

    public static void main(String[] args) {

/*        final int COUNT_BITS = Integer.SIZE - 3;
        final int CAPACITY   = (1 << COUNT_BITS) - 1;

        int b = Integer.SIZE - 3;
        System.out.println(CAPACITY);*/


        hhh:
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 5; ++j) {
                System.out.println(j);
                if (j == 3) {
                    continue hhh;
                }
            }
        }


    }



}
