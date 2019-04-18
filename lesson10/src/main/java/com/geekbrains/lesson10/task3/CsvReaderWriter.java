package com.geekbrains.lesson10.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderWriter {

    public void writeCsv(String filePath, List<Student> list) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student s : list) {
                writer.append(String.valueOf(s.getId()));
                writer.append(", ");
                writer.append(s.getName());
                writer.append(", ");
                writer.append(String.valueOf(s.getScore()));
                writer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> readCsv(String filePath) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                if (fields.length > 0) {
                    Student student = new Student();
                    student.setId(Integer.parseInt(fields[0]));
                    student.setName(fields[1]);
                    student.setScore(Integer.parseInt(fields[2]));
                    list.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
