package com.ares.service.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程依次打印1-100
 * 例：
 * Thread-0: 1
 * Thread-1: 2
 * Thread-2: 3
 * Thread-0: 4
 * ...
 * Thread-0: 100
 *
 * @author fansheng
 * @date 2020/12/11
 */
public class ConditionDemo1 {

    private static final Lock LOCK = new ReentrantLock();

    private static final Condition C1 = LOCK.newCondition();
    private static final Condition C2 = LOCK.newCondition();
    private static final Condition C3 = LOCK.newCondition();

    /**
     * 当前要打印的数字
     */
    private static int i = 1;

    /**
     * 标识当前应该是第几号线程打印
     */
    private static int index = 1;

    /**
     * 最大打印数字
     */
    private static final int MAX = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            LOCK.lock();
            try {
                while (i <= MAX) {
                    while (index != 1) {
                        C1.await();
                    }
                    print();
                    index = 2;
                    C2.signal();
                    C1.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }).start();

        new Thread(() -> {
            LOCK.lock();
            try {
                while (i <= MAX) {
                    while (index != 2) {
                        C2.await();
                    }
                    print();
                    index = 3;
                    C3.signal();
                    C2.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }).start();

        new Thread(() -> {
            LOCK.lock();
            try {
                while (i <= MAX) {
                    while (index != 3) {
                        C3.await();
                    }
                    print();
                    index = 1;
                    C1.signal();
                    C3.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }).start();
    }

    /**
     * 打印
     */
    private static void print() {
        System.out.println(Thread.currentThread().getName() + ": " + i++);
        if (i > MAX) {
            System.exit(1);
        }
    }

}
