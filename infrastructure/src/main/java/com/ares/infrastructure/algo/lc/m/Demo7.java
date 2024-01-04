package com.ares.infrastructure.algo.lc.m;

/**
 * @author  0xZzzz
 * @date 2020/4/8
 */
public class Demo7 {

    public static void main(String[] args) {
        algorithms(33, 23, 30);
    }

    private static void algorithms(int m, int n, int k) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (calculateDigitSum(i) + calculateDigitSum(j) <= k) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    /**
     * 计算数字的数位之和
     */
    private static int calculateDigitSum(int num) {
        int res = 0;
        do {
            res += num % 10;
            num /= 10;
        } while (num > 10);
        return res;
    }

}
