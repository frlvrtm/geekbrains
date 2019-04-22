package com.geekbrains.project.txt;

import com.geekbrains.project.dto.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriter {

    public static List<Student> reader(String filePath) {
        BufferedReader reader = null;
        List<Student> list = new ArrayList<>();
        String line;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Student student = new Student();
                student.setFirstName(fields[0]);
                student.setLastName(fields[1]);
                student.setMiddleName(fields[2]);
                student.setSpeciality(fields[3]);
                student.setPointAverage(Double.parseDouble(fields[4]));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void writer(String filePath, List<Student> list) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (Student s : list) {
                writer.append(s.getFirstName());
                writer.append(",");
                writer.append(s.getLastName());
                writer.append(",");
                writer.append(s.getMiddleName());
                writer.append(",");
                writer.append(s.getSpeciality());
                writer.append(",");
                writer.append(String.valueOf(s.getPointAverage()));
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
