package com.ares.service.algorithms.leetcode.middle;

import java.util.Arrays;

/**
 * 生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0
 * 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * @author  0xZzzz
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
     * 时间复杂度 O(m*n)
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
