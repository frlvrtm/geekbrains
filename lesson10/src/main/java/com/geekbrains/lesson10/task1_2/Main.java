package com.geekbrains.lesson10.task1_2;

import java.util.Arrays;

public class Main {

    private static int[] array = {4, 4, 4, 2, 3, 1, 1};

    public static void main(String[] args) {
        ArrayOperations operations = new ArrayOperations();
        int[] result = operations.change(array);
        System.out.println(Arrays.toString(result));
        System.out.println(operations.check(array));
    }
}
