package com.ares.service.algorithms.array;

import java.util.Arrays;

/**
 * 从数组中移除重复元素，不需要物理删除重复元素，替换为null，或者为空或默认值即可
 *
 * @author 0xZzzz
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        int[][] test = new int[][] {
            {1, 1, 2, 2, 3, 4, 5},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
        }
    }

    /**
     * 在Java中从数组中删除重复项的方法，不使用Collection类，例如 Set或ArrayList。这种方法的算法很简单，它首先对数组进行排序，然后比较相邻的对象，留下重复数据，这已经存在于结果中
     */
    private static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // 对数组进行排序以将重复项放在一起
        Arrays.sort(numbersWithDuplicates);

        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;

    }
}