package com.geekbrains.lesson6.model;

import java.util.Arrays;

public class Array implements Runnable {
    /**
     * Размер массива
     */
    private static final int SIZE = 10000000;
    /**
     * Половина массива
     */
    private static final int HALF = SIZE / 2;
    /**
     * Массив
     */
    private float[] array;
    /**
     * Левая часть массива
     */
    private float[] leftPart;
    /**
     * Правая часть массива
     */
    private float[] rightPart;

    public Array() {
        this.array = new float[SIZE];
        //Заполняет массив единицами
        Arrays.fill(this.array, 1.f);
    }

    /**
     * Проходит по всему массиву
     * Для каждой ячейки считает новое значение по формуле
     *
     * @param size  размер
     * @param array массив
     */
    private void fillArray(int size, float[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i]
                    * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2)
            );
        }
    }

    /**
     * Бежит по массиву и вычисляет значения
     * Засекает время выполнения
     */
    public void method1() {
        long a = System.currentTimeMillis();
        fillArray(SIZE, array);
        System.out.println(System.currentTimeMillis() - a);
    }

    /**
     * Разбивает массив на две части
     * В двух потоках вычисляет новые значения
     * Склеивает эти массивы обратно в один
     * Засекает время выполнения
     */
    public void method2() {
        long a = System.currentTimeMillis();
        leftPart = new float[HALF];
        rightPart = new float[HALF];
        System.arraycopy(array, 0, leftPart, 0, HALF);
        System.arraycopy(array, HALF, rightPart, 0, HALF);
        Thread thread1 = new Thread();
        thread1.start();
        Thread thread2 = new Thread();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(leftPart, 0, array, 0, HALF);
        System.arraycopy(rightPart, 0, array, HALF, HALF);
        System.out.println(System.currentTimeMillis() - a);
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("thread1")) {
            fillArray(HALF, leftPart);
        } else {
            fillArray(HALF, rightPart);
        }
    }
}
