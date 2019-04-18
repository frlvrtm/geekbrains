package com.geekbrains.lesson9.task1_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String filePath = "data.csv";

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student st1 = new Student(1, "Bob", 5);
        Student st2 = new Student(2, "Alex", 4);
        Student st3 = new Student(3, "Johny", 4);
        list.add(st1);
        list.add(st2);
        list.add(st3);

        CsvReaderWriter.writeCsv(filePath, list);
        List<Student> result = CsvReaderWriter.readCsv(filePath);

        for (Student s : result) {
            System.out.println(s);
        }
    }
}
