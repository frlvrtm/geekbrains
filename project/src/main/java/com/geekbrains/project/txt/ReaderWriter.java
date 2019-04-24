package com.geekbrains.project.txt;

import com.geekbrains.project.dto.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriter {

    public static List<Student> reader(String filePath) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Student student = new Student(fields[0], fields[1], fields[2], fields[3], Double.parseDouble(fields[4]));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
