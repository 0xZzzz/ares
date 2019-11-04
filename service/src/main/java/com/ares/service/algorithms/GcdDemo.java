package com.ares.service.algorithms;

/**
 * 求两个数的最大公因数，GCD(greatest common divisor)
 *
 * @author fansheng
 * @since 2019/11/4
 */
public class GcdDemo {

    public static void main(String[] args) {
        System.out.println(gcd(10, 10));
    }

    /**
     * 时间复杂度：O(log n)
     */
    private static long gcd(long m, long n) {
        if (m < n) {
            long tmp = n;
            n = m;
            m = tmp;
        }
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

}
