package com.ares.infrastructure.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * exchanger demo
 *
 * @author 0xZzzz
 */
public class ExchangerDemo {

    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(2, 2,
        0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
        NamingThreadFactory.getInstance("exchanger-demo"));

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) {
        EXECUTOR.execute(() -> exchange("1"));
        EXECUTOR.execute(() -> exchange("2"));
        EXECUTOR.shutdown();
    }

    private static void exchange(String txt) {
        try {
            System.out.println(Thread.currentThread().getName() + "正在把数据" + txt + "换出去");
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            System.out.println(Thread.currentThread().getName() + "交换回的数据为" + EXCHANGER.exchange(txt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
