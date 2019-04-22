package com.geekbrains.project.dao;

import com.geekbrains.project.dto.Student;

import java.util.List;

public interface StudentDao {
    Student getStudent(String name);

    void update(Student student);

    void insert(Student student);

    void deleteById(int id);

    List<Student> getAllStudents();

    List<Student> getStudentsBySpec(String title);

    void exportToDB(List<Student> list);

    String toString(List<Student> list);
}
