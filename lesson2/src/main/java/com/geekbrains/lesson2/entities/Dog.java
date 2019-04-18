package com.geekbrains.lesson2.entities;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(getName() + " пробежал " + distance + " м");
        } else {
            System.out.println("Ограничение на бег у собаки - 500 м");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(getName() + " проплыл " + distance + " м");
        } else {
            System.out.println("Ограничение на плавание у собаки - 10 м");
        }
    }
}
