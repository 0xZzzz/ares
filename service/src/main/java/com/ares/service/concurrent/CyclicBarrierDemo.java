package com.ares.service.concurrent;

import com.ares.common.utils.NamingThreadFactory;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CyclicBarrier: 控制若干线程全部都到达某一点之后再继续执行
 *
 * @author 0xZzzz
 */
public class CyclicBarrierDemo {

    private static final int NUM = 3;

    private static final int THRESHOLD = NUM - 1;

    private static final CyclicBarrier CB = new CyclicBarrier(NUM);

    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(NUM, NUM, 0L,
        TimeUnit.MILLISECONDS, new SynchronousQueue<>(), NamingThreadFactory.getInstance("cyclic-barrier-demo"));

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            EXECUTOR.execute(CyclicBarrierDemo::task);
        }
        EXECUTOR.shutdown();
    }

    /**
     * 集合任务
     */
    private static void task() {
        together(1);
        together(2);
        together(3);
        together(4);
    }

    /**
     * 集合
     *
     * @param i 集合点
     */
    private static void together(int i) {
        try {
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
            System.out.println(Thread.currentThread().getName() + "即将到达集合地点" + i + "，当前已有" +
                (CB.getNumberWaiting() + 1) + "个已经到达，" +
                (CB.getNumberWaiting() == THRESHOLD ? "都到齐了，继续走啊" : "正在等候"));
            CB.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
