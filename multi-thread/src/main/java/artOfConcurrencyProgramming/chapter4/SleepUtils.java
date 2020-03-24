package artOfConcurrencyProgramming.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-07-13 10:58
 **/
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
