package com.geekbrains.lesson9.task3;

public class Coder {

    static String encryption(String text, String key) {
        char[] textArr = text.toCharArray();
        char[] keyArr = key.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            textArr[i] += keyArr[i % keyArr.length];
        }
        return new String(textArr);
    }

    static String decryption(String text, String key) {
        char[] textArr = text.toCharArray();
        char[] keyArr = key.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            textArr[i] -= keyArr[i % keyArr.length];
        }
        return new String(textArr);
    }
}
