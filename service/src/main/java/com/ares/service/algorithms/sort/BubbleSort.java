package com.ares.service.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序，时间复杂度O(n^2)，n * n
 *
 * @author 0xZzzz
 * @since 2019/5/5
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 2, 6};
        bubbleSortImproved(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            System.out.println("第" + (i + 1) + "次循环结束：" + Arrays.toString(arr));
        }
        System.out.println("排序结束：" + Arrays.toString(arr));
    }

    /**
     * 交换数组指定下标位置的元素
     */
    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    /**
     * 冒泡排序优化
     */
    private static void bubbleSortImproved(int[] number) {
        boolean swapped = true;
        int last = number.length - 2;
        int loopCount = 1;
        // 只有在交换发生时继续循环
        while (swapped) {
            swapped = false;
            for (int i = 0; i <= last; i++) {
                if (number[i] > number[i + 1]) {
                    swap(number, i, i + 1);
                    // 标记交换发生
                    swapped = true;
                }
            }
            System.out.println("第" + loopCount++ + "次循环结束：" + Arrays.toString(number));
            // 每次循环过后最大的元素会移动到数组的末端
            last--;
        }
    }

}
