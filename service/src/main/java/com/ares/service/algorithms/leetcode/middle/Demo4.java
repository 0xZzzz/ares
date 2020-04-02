package com.ares.service.algorithms.leetcode.middle;

import java.util.Arrays;

/**
 * @author fansheng
 * @date 2020/4/2
 */
public class Demo4 {

    public static void main(String[] args) {
        int[][] input = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        algorithms(input);
    }
    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 算上结果数组 O(n) 不算结果数组 O(1)
     */
    private static void algorithms(int[][] input) {
        int[][] output = new int[input.length][];
        // 定义8个方向
        int[][] direction = {
            {-1, -1},
            {0, -1},
            {1, -1},
            {-1, 0},
            {1, 0},
            {-1, 1},
            {0, 1},
            {1, 1}
        };
        // i 为纵坐标，j 为横坐标
        for (int i = 0; i < input.length; i++) {
            int[] row = input[i];
            output[i] = new int[row.length];
            for (int j = 0; j < row.length; j++) {
                int cell = row[j];
                int liveCnt = 0;
                for (int[] d : direction) {
                    int a = j + d[0];
                    int b = i + d[1];
                    if (a >= 0 && b >= 0 && b < input.length && a < row.length && input[b][a] == 1) {
                        liveCnt++;
                    }
                }
                int result = cell;
                if (cell == 0) {
                    if (liveCnt == 3) {
                        result = 1;
                    }
                } else {
                    if (liveCnt < 2 || liveCnt > 3) {
                        result = 0;
                    }
                }
                output[i][j] = result;
            }
        }
        for (int[] row : output) {
            System.out.println(Arrays.toString(row));
        }
    }

}
