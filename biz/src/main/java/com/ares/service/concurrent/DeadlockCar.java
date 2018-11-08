package com.ares.service.concurrent;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁示例：四个方向行驶的车分别占用了对方的路
 *
 * @author 0xZzzz
 */
public class DeadlockCar extends Thread {

    public static void main(String[] args) {
        DeadlockCar east = new DeadlockCar(Direction.EAST);
        DeadlockCar west = new DeadlockCar(Direction.WEST);
        DeadlockCar south = new DeadlockCar(Direction.SOUTH);
        DeadlockCar north = new DeadlockCar(Direction.NORTH);
        east.start();
        west.start();
        south.start();
        north.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        east.interrupt();
    }

    private Direction direction;

    public DeadlockCar(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        try {
            direction.getOccupy().lockInterruptibly();
            TimeUnit.SECONDS.sleep(5);
            direction.getDest().lockInterruptibly();
            System.out.println("car to " + direction.name() + " has passed");
        } catch (Exception e) {
            System.out.println("car to " + direction.name() + " is killed");
        } finally {
            if (direction.getOccupy().isHeldByCurrentThread()) {
                direction.getOccupy().unlock();
            }
            if (direction.getDest().isHeldByCurrentThread()) {
                direction.getDest().unlock();
            }
        }
    }

    /**
     * 方向
     */
    enum Direction {

        /**
         * 东西南北
         */
        EAST(new ReentrantLock()),
        WEST(new ReentrantLock()),
        SOUTH(new ReentrantLock()),
        NORTH(new ReentrantLock());

        /**
         * 占据的方向
         */
        private static final Map<Direction, ReentrantLock> OCCUPY = Collections.unmodifiableMap(
            new HashMap<Direction, ReentrantLock>() {
                {
                    // 向南去的车占据了向西的路
                    put(SOUTH, WEST.getDest());
                    // 向北去的车占据了向东的路
                    put(NORTH, EAST.getDest());
                    // 向东去的车占据了向南的路
                    put(EAST, SOUTH.getDest());
                    // 向西去的车占据了向北的路
                    put(WEST, NORTH.getDest());
                }
            });

        public ReentrantLock getOccupy() {
            return OCCUPY.get(this);
        }

        /**
         * 要去的方向
         */
        @Getter
        private ReentrantLock dest;

        Direction(ReentrantLock dest) {
            this.dest = dest;
        }
    }

}
