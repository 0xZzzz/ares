package com.ares.service.algorithms;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 在int数组中寻找丢失的元素
 *
 * @author 0xZzzz
 */
public class MissingNumberInArray {

    public static void main(String[] args) {

        // 丢失一个元素
        printMissingNumber(new int[] {1, 4, 3, 2, 6}, 6);

        // 丢失两个元素
        printMissingNumber(new int[] {1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // 丢失三个元素
        printMissingNumber(new int[] {1, 2, 3, 4, 6, 9, 8}, 10);

        // 丢失四个元素
        printMissingNumber(new int[] {1, 2, 3, 4, 9, 8}, 10);

        // 仅仅一个丢失元素
        int[] iArray = new int[] {1, 2, 3, 5};
        int missing = getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d %n",
            Arrays.toString(iArray), missing);
    }

    /**
     * 数组中丢失超过一个元素也能工作
     */
    private static void printMissingNumber(int[] numbers, int count) {
        // 确定一共丢失了几个元素
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
            Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }

    /**
     * 从1开始的数组，只丢失一个元素，可以用这个方式
     */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        // 期望的和，也就是不缺元素时的数组元素总和
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        // 期望的元素总和减去实际的元素总和就是丢失的元素
        return expectedSum - actualSum;
    }

}