package com.geekbrains.lesson4;

import com.geekbrains.lesson4.classes.MyClass;
import com.geekbrains.lesson4.exception.MyArrayDataException;
import com.geekbrains.lesson4.exception.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = myClass.myMethod(array);
            System.out.println("Сумма элементов массива равна " + result);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("неправильный размер массива!");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("в ячейке массива лежит что-то не то!");
            System.out.println("Ошибка в ячейке: " + e.getI() + "x" + e.getJ());
        }
    }
}
