package ua.hillel.java.enterprise.test;

// Task 3.
// Given the following class:
//
//    public class IncrementSynchronize {
//       private int value = 0;
//       getNextValue()
//    }
//
// Write three different method options for getNextValue() that will return value++,
// each method needs to be synchronized in a different way.

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Oleg Kosenkov
 * @Date   2019.04.12
 */
public class IncrementSynchronize {
    private int value = 0;
    private Lock lock = new ReentrantLock();
    private Semaphore permission = new Semaphore(1,true);

    /**
     * Returns the value, and then increments it.
     * The method is synchronized on intrinsic monitor.
     * @return the current value.
     */
    synchronized public int getNextValue() {
        return value++;
    }

    /**
     * Returns the value, and then increments it.
     * The method is synchronized on the lock object.
     * @return the current value.
     */
    public int lockedGetNextValue() {
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns the value, and then increments it.
     * The method is synchronized with the one-thread semaphore object.
     * @return the current value.
     */
    public int semaphoredGetNextValue() {
        try {
            permission.acquire();
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            permission.release();
        }
    }
}
