package com.geekbrains.lesson9.task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command:");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "exit":
                    return;
                case "/encrypt":
                    encrypt();
                    break;
                case "/decrypt":
                    decrypt();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static String readFile(String fileName) {
        char symb;
        StringBuilder s = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            int count;
            while ((count = fileReader.read()) != -1) {
                symb = (char) count;
                s.append(symb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    private static void writeFile(String fileName, String text) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName() {
        scanner = new Scanner(System.in);
        System.out.println("Enter file: ");
        return scanner.nextLine();
    }

    private static String getKey() {
        scanner = new Scanner(System.in);
        System.out.println("Enter key: ");
        return scanner.nextLine();
    }

    private static void encrypt() {
        try {
            String fileName1 = "data.txt";//getFileName();
            String fileName2 = "data-encrypted.txt";//getFileName();
            String fileText = readFile(fileName1);
            String key = getKey();
            String encryptedText = Coder.encryption(fileText, key);
            writeFile(fileName2, encryptedText);
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decrypt() {
        try {
            String fileName1 = "data-encrypted.txt";//getFileName();
            String fileName2 = "data-decrypted.txt";//getFileName();
            String fileText = readFile(fileName1);
            String key = getKey();
            String decryptedText = Coder.decryption(fileText, key);
            writeFile(fileName2, decryptedText);
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
