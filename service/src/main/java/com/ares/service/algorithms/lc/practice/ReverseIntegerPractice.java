package com.ares.service.algorithms.lc.practice;

import com.ares.service.algorithms.lc.m.ReverseInteger;

/**
 * {@link ReverseInteger} practice
 *
 * @author fansheng
 * @date 2021/7/21
 */
public class ReverseIntegerPractice {

    public static void main(String[] args) {
        System.out.println(reverseInteger(111111112));
    }

    private static int reverseInteger(int i) {
        int reg = i > 0 ? 1 : -1;
        int ret = 0;
        i *= reg;
        while (i > 0) {
            int n = ret;
            int c = i % 10;
            i /= 10;
            n = n * 10 + c;
            if (n / 10 != ret) {
                return 0;
            }
            ret = n;
        }
        return ret * reg;
    }

}
