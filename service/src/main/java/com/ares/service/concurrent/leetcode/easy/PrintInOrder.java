package com.ares.service.concurrent.leetcode.easy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * <p>
 * 示例 2:
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 *
 * @author fansheng
 * @date 2020/12/11
 */
public class PrintInOrder {

    public static void main(String[] args) {
        int[] cmds = new int[]{1, 2, 3};
        Foo foo = new Foo();
        new Thread(() -> execute(foo, cmds[0])).start();
        new Thread(() -> execute(foo, cmds[1])).start();
        new Thread(() -> execute(foo, cmds[2])).start();
    }

    private static void execute(Foo foo, int cmd) {
        if (cmd == 1) {
            foo.first(() -> System.out.print("first"));
            return;
        }
        if (cmd == 2) {
            foo.second(() -> System.out.print("second"));
            return;
        }
        if (cmd == 3) {
            foo.third(() -> System.out.print("third"));
            return;
        }
        throw new IllegalArgumentException("unsupported command " + cmd);
    }

    private static class Foo {

        private static final Lock LOCK = new ReentrantLock();

        private static final Condition C2 = LOCK.newCondition();
        private static final Condition C3 = LOCK.newCondition();

        private static int index = 1;

        public void first(Runnable printFirst) {
            LOCK.lock();
            try {
                printFirst.run();
                index = 2;
                C2.signal();
            } finally {
                LOCK.unlock();
            }
        }

        public void second(Runnable printSecond) {
            LOCK.lock();
            try {
                while (index != 2) {
                    C2.await();
                }
                printSecond.run();
                index = 3;
                C3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }

        public void third(Runnable printThird) {
            LOCK.lock();
            try {
                while (index != 3) {
                    C3.await();
                }
                printThird.run();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }

    }

}