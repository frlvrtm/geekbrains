package com.geekbrains.lesson11;

public class Main {

    public static void main(String[] args) {
        System.out.println("#### Interface scanning ####");
        Class aClass = Tests.class;
        System.out.println("#### Class name: " + aClass.getSimpleName() + " ####");
        Handler.start(aClass);
    }
}

