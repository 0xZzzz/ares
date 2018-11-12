package com.ares.service.algorithms;

import java.util.Arrays;

/**
 * 数组反转
 *
 * @author 0xZzzz
 */
public class ArrayReverse {

    public static void main(String[] args) {
        String[] strArr = new String[] {"one", "two", "three"};
        reverse(strArr, 0, strArr.length);
        System.out.println(Arrays.toString(strArr));

        Integer[] intArr = new Integer[] {1, 2, 3};
        reverse(intArr, 0, intArr.length);
        System.out.println(Arrays.toString(intArr));
    }

    public static void reverse(final Object[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        Object tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

}
