package com.ares.infrastructure.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁示例
 *
 * @author 0xZzzz
 */
public class DeadlockDemo {

    public static void main(String[] args) {

        ReentrantLock l1 = new ReentrantLock();
        ReentrantLock l2 = new ReentrantLock();

        Thread t1 = new Race(l1, l2);
        Thread t2 = new Race(l2, l1);

        t1.start();
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

    static class Race extends Thread {

        private ReentrantLock l1;

        private ReentrantLock l2;

        public Race(ReentrantLock l1, ReentrantLock l2) {
            this.l1 = l1;
            this.l2 = l2;
        }

        @Override
        public void run() {
            try {
                l1.lockInterruptibly();
                TimeUnit.SECONDS.sleep(2);
                l2.lock();
                System.out.println(Thread.currentThread().getName() + " has passed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " has been killed");
            } finally {
                if (l1.isHeldByCurrentThread()) {
                    l1.unlock();
                }
            }
        }

    }

}
