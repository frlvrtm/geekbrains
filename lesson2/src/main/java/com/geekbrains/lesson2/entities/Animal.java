package com.geekbrains.lesson2.entities;

public class Animal {
    private String name;
    private static int Count = 0;

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
        Count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return Count;
    }

    public void run(int distance) {
        System.out.println(getName() + " пробежал " + distance + " м");
    }

    public void swim(int distance) {
        System.out.println(getName() + " проплыл " + distance + " м");
    }
}
