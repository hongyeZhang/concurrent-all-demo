package interview.volatiletest;

/**
 * @author : ZHQ
 * @date : 2020/3/15
 */
class MyData {
    volatile int number = 0;

    public void change() {
        number = 60;
    }

    public void addOne() {
        number++;
    }
}
