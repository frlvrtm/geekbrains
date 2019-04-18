package com.geekbrains.lesson5;

import com.geekbrains.lesson5.model.Phonebook;

import java.util.*;

public class Main {

    private static String[] array = new String[]{
            "java",
            "core",
            "arrayList",
            "linkedList",
            "java",
            "hashMap",
            "hashSet",
            "equals",
            "hashCode",
            "123",
            "core",
            "java"
    };

    public static void main(String[] args) {
        System.out.println("---------------TASK 1:---------------");
        Set<String> tempArray = new LinkedHashSet<String>();
        Collections.addAll(tempArray, array);
        System.out.println(tempArray);
        for (String temp : tempArray) {
            int count = 0;
            for (String arr : array) {
                if (temp.equals(arr)) {
                    count++;
                }
            }
            System.out.println(temp + " = " + count);
        }
        System.out.println("---------------TASK 2:---------------");
        Phonebook phonebook = new Phonebook();
        phonebook.add("8(900)111-11-11", "Petrov");
        phonebook.add("8(900)000-00-00", "Sidorov");
        phonebook.add("8(800)555-35-35", "Petrov");
        System.out.println("Phonebook:" + "\n" + phonebook);
        System.out.println("Search:");
        phonebook.get("Petrov");
    }
}
