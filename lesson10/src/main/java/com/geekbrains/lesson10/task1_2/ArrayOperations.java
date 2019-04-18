package com.geekbrains.lesson10.task1_2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class ArrayOperations {
    public int[] change(int[] array) {
        int[] newArr = ArrayUtils.subarray(array, ArrayUtils.lastIndexOf(array, 4) + 1, ArrayUtils.getLength(array));
        if (Arrays.equals(array, newArr)) {
            throw new RuntimeException();
        }
        return newArr;
    }

    public boolean check(int[] array) {
        if (ArrayUtils.contains(array, 1) && ArrayUtils.contains(array, 4)) {
            for (int i1 : array) {
                if (i1 != 1 && i1 != 4) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
