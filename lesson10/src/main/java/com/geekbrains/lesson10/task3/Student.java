package com.geekbrains.lesson10.task3;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private int score;

    public Student() {
    }

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
