package javaConcurrencyInPractice.Chapter7;

import java.math.BigInteger;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-11 10:19
 **/
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(aSecondOfPrimes().size());
    }

    public static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}
