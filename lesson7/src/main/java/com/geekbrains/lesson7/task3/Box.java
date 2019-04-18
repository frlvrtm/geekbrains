package com.geekbrains.lesson7.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list;

    public Box(T... fruits) {
        this.list = new ArrayList<T>(Arrays.asList(fruits));
    }

    public float getWeight() {
        if (list.size() > 0) {
            return list.get(0).getWeight() * list.size();
        } else {
            return 0;
        }
    }

    public void add(T fruit) {
        this.list.add(fruit);
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    public void shiftFruits(Box<T> box) {
        box.list.addAll(this.list);
        this.list.clear();
    }
}
