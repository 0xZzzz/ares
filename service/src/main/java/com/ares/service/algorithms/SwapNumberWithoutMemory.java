package com.ares.service.algorithms;

/**
 * 交换数字
 *
 * @author fansheng
 * @date 2020/3/25
 */
public class SwapNumberWithoutMemory {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        // solution 1
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + ", " + b);
        // solution 2
        a = (a + b) - (b = a);
        System.out.println(a + ", " + b);
        // solution 3
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }

}
