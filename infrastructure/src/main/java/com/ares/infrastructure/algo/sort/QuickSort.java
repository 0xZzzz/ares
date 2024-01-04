package com.ares.infrastructure.algo.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {22, 11, 2, 34, 21, 54, 65, 87, 12, 55};
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort1(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right, x = arr[left];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                // 从左向右找第一个大于等于x的数
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            // 保存枢纽元
            arr[i] = x;
            // 排序小元素
            quickSort1(arr, left, i - 1);
            // 排序大元素
            quickSort1(arr, i + 1, right);
        }
    }

    private static void quickSort2(int[] arr, int left, int right) {
        int pivot = median3(arr, left, right);
        System.out.println(Arrays.toString(arr));
        // 开始分区
        int i = left, j = right - 1;
        while (true) {
            while (arr[++i] < pivot) {
            }
            while (arr[--j] >= pivot) {
            }
            if (i < j) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        // 保存枢纽元
        swap(arr, i, right - 1);
        // 排序小元素
        quickSort2(arr, left, i - 1);
        // 排序大元素
        quickSort2(arr, i + 1, right);
    }

    /**
     * 三数中值分割法
     * 返回左边、中间和右边的中位数。排序它们并隐藏枢纽元
     */
    private static int median3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[center] < arr[left]) {
            swap(arr, left, center);
        }
        if (arr[right] < arr[left]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[center]) {
            swap(arr, center, right);
        }
        //将枢纽元放在right - 1位置
        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    /**
     * 交换
     */
    private static void swap(int[] arr, int e1, int e2) {
        int tmp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = tmp;
    }

}
