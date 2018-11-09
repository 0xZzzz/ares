package com.ares.service.algorithms;

import java.util.Arrays;

/**
 * 不排序，求数组中的最大值和最小值
 *
 * @author 0xZzzz
 */
public class MaximumMinimumArrayDemo {

    public static void main(String[] args) {
        largestAndSmallest(new int[] {-20, 34, 21, -87, 92, Integer.MAX_VALUE});
        largestAndSmallest(new int[] {10, Integer.MIN_VALUE, -2});
        largestAndSmallest(new int[] {Integer.MAX_VALUE, 40, Integer.MAX_VALUE});
        largestAndSmallest(new int[] {1, -1, 0});
    }

    private static void largestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }
        System.out.println("Given integer array : " + Arrays.toString(numbers));
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }
}