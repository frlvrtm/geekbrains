package com.geekbrains.lesson2.entities;

public class Cat extends Animal {
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(getName() + " пробежал " + distance + " м");
        } else {
            System.out.println("Ограничение на бег у кота - 500 м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }
}
