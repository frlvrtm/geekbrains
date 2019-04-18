package com.geekbrains.lesson4.classes;

import com.geekbrains.lesson4.exception.MyArrayDataException;
import com.geekbrains.lesson4.exception.MyArraySizeException;

public class MyClass {

    public int myMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    int elem = Integer.valueOf(array[i][j]);
                    sum = sum + elem;
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
