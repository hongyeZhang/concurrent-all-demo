package javaConcurrencyInPractice.Chapter12;

import java.util.concurrent.Semaphore;

/**
 * @program: multi-thread
 * @description:
 * @author: ZHQ
 * @create: 2019-02-14 10:23
 **/
public class BoundedBuffer<E> {
    private final Semaphore availableItems, availableSpaces;
    private final E[] items;
    private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpaces.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E item = items[takePosition];
        items[takePosition] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return item;
    }
}
