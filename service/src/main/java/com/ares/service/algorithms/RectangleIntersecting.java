package com.ares.service.algorithms;

/**
 * 判断长方形是否有交集
 *
 * @author fansheng
 * @date 2020/3/25
 */
public class RectangleIntersecting {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(7, 7);
        Point p3 = new Point(6, 6);
        Point p4 = new Point(10, 10);

        Rectangle r1 = new Rectangle(p1, p2);
        Rectangle r2 = new Rectangle(p3, p4);
        System.out.println(r1.isOverLapping(r2));
    }

    /**
     * 长方形
     */
    static class Rectangle {

        /**
         * 左上顶点
         */
        private final Point topLeft;

        /**
         * 右下顶点
         */
        private final Point bottomRight;

        Rectangle(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        /**
         * 判断当前长方形与另外一个长方形是否有交集
         */
        boolean isOverLapping(Rectangle other) {
            return !(topLeft.x > other.bottomRight.x
                || topLeft.y > other.bottomRight.y
                || bottomRight.x < other.topLeft.x
                || bottomRight.y < other.topLeft.y);
        }

    }

    /**
     * 点
     */
    static class Point {

        /**
         * x 轴坐标
         */
        int x;

        /**
         * y 轴坐标
         */
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
