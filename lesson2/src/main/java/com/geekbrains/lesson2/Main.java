package com.geekbrains.lesson2;

import com.geekbrains.lesson2.entities.Animal;
import com.geekbrains.lesson2.entities.Cat;
import com.geekbrains.lesson2.entities.Dog;
import com.geekbrains.lesson2.entities.Tiger;

public class Main {
    public static void main(String[] args) {
        Animal[] array = new Animal[4];
        array[0] = new Cat("Том");
        array[1] = new Dog("Барон");
        array[2] = new Tiger("Персик");
        array[3] = new Cat("Барсик");

        for (Animal a : array) {
            a.run(250);
            a.swim(18);
            System.out.println();
        }

        System.out.println("Было создано котов: " + Cat.getCatCount());
        System.out.println("Было создано собак: " + Dog.getDogCount());
        System.out.println("Было создано тигров: " + Tiger.getTigerCount());
        System.out.println("Всего животных: " + Animal.getCount());
    }
}
