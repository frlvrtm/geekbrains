package com.geekbrains.lesson2.entities;

public class Tiger extends Animal {
    private static int tigerCount = 0;

    public Tiger(String name) {
        super(name);
        tigerCount++;
    }

    public static int getTigerCount() {
        return tigerCount;
    }
}
