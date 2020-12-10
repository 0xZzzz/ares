package com.ares.service.algorithms.leetcode.middle;

import java.util.Arrays;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author  0xZzzz
 * @date 2020/4/7
 */
public class Demo6 {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        algorithms1(arr);
        System.out.println();
        algorithms2(arr);
        System.out.println();
        algorithms3(arr);
    }

    /**
     * 需要占用额外空间，时间复杂度 O(n^2)，空间复杂度 O(n^2)
     */
    private static void algorithms1(int[][] arr) {
        int[][] result = new int[arr.length][];
        // 规律：旋转前的作为为 (x,y) 旋转后的坐标为 (y,n-x-i)
        for (int i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            for (int j = 0; j < row.length; j++) {
                if (result[j] == null) {
                    result[j] = new int[result.length];
                }
                int cell = row[j];
                result[j][arr.length - i - 1] = cell;
            }
        }
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 原地旋转，时间复杂度 O(n^2)，空间复杂度 O(1)
     * 旋转有四个点形成了环，所以每次循环用一个临时变量存储当前节点，交换四个节点的值，这样就无需额外的存储空间
     * 当 n(n 为边长) 为偶数时，遍历横纵坐标的范围均为 n / 2
     * 当 n 为奇数时，遍历横坐标的范围为 (n + 1) / 2，遍历纵坐标的范围为 n / 2，也就是横坐标要多遍历一遍
     */
    private static void algorithms2(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = arr[i][j];
                // 四个坐标要好好推敲一下
                arr[i][j] = arr[n - j - 1][i];
                arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
                arr[n - i - 1][n - j - 1] = arr[j][n - i - 1];
                arr[j][n - i - 1] = temp;
            }
        }
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 翻转，先水平翻转，再沿对角线翻转，对于每一次翻转操作，我们都需要枚举矩阵中一半的元素。
     * 时间复杂度 O(n^2)，空间复杂度 O(1)
     */
    private static void algorithms3(int[][] arr) {
        int n = arr.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - i - 1][j];
                arr[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

}
