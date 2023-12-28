package com.ares.service.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 可命名thread factory {@link java.util.concurrent.Executors#defaultThreadFactory()}
 *
 * @author 0xZzzz
 */
public class NamingThreadFactory implements ThreadFactory {

    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    /**
     * 获取线程工厂实例
     *
     * @param name 线程名称
     * @return 线程工厂实例
     */
    public static NamingThreadFactory getInstance(String name) {
        return new NamingThreadFactory(name);
    }

    private NamingThreadFactory(String name) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "pool-" + POOL_NUMBER.getAndIncrement() + "-" + name + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }

}
