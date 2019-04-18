package com.geekbrains.lesson7;

import com.geekbrains.lesson7.task3.Apple;
import com.geekbrains.lesson7.task3.Box;
import com.geekbrains.lesson7.task3.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{
                1, 2, 3, 4, 5
        };
        String[] strArr = new String[]{
                "element1", "element2", "element3", "element4", "element5"
        };
        System.out.println("------------TASK1------------");
        System.out.println("Swap elements:");
        swap(intArr, 1, 3);
        swap(strArr, 1, 3);
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(strArr));

        System.out.println("------------TASK2------------");
        ArrayList<Integer> integers = ToArrayList(intArr);
        ArrayList<String> strings = ToArrayList(strArr);
        System.out.println("ArrayLists:");
        System.out.println(integers.toString());
        System.out.println(strings.toString());

//        System.out.println("Swap elements:");
//        swapV2(strings, 1, 3);
//        swapV2(integers, 1, 3);
//        System.out.println(strings.toString());
//        System.out.println(integers.toString());

        System.out.println("------------TASK3------------");
        Box<Apple> appleBox = new Box<Apple>(new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<Orange>(new Orange(), new Orange(), new Orange());
        Orange orange = new Orange();
        orangeBox.add(orange);
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        appleBox.add(apple1);
        appleBox.add(apple2);

        System.out.println("Weight appleBox: " + appleBox.getWeight());
        System.out.println("Weight orangeBox: " + orangeBox.getWeight());

        boolean b = appleBox.compare(orangeBox);
        System.out.println("Compare: " + b);

        Box<Apple> appleBox2 = new Box<Apple>();
        appleBox.shiftFruits(appleBox2);
        System.out.println("Weight appleBox: " + appleBox.getWeight());
        System.out.println("Weight appleBox2: " + appleBox2.getWeight());
    }

    /**
     * метод, который меняет два элемента массива местами
     *
     * @param array
     * @param element1
     * @param element2
     */
    private static void swap(Object[] array, int element1, int element2) {
        Object temp = array[element1];
        array[element1] = array[element2];
        array[element2] = temp;
    }

    /**
     * метод, который преобразует массив в ArrayList
     *
     * @param array
     * @param <T>
     * @return
     */
    private static <T> ArrayList<T> ToArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<T>();
        Collections.addAll(list, array);
        return list;
    }

    /**
     * метод, который меняет два элемента массива местами
     * У коллекций есть готовый метод Collections.swap
     *
     * @param list
     * @param element1
     * @param element2
     */
    private static void swapV2(List<?> list, int element1, int element2) {
        Collections.swap(list, element1, element2);
    }
}
