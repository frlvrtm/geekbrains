package com.geekbrains.project.dto;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String speciality;
    private double pointAverage;

    public Student() {
    }

    public Student(String firstName, String lastName, String middleName, String speciality, double pointAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.speciality = speciality;
        this.pointAverage = pointAverage;
    }

    public Student(int id, String firstName, String lastName, String middleName, String speciality, double pointAverage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.speciality = speciality;
        this.pointAverage = pointAverage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getPointAverage() {
        return pointAverage;
    }

    public void setPointAverage(double pointAverage) {
        this.pointAverage = pointAverage;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", pointAverage=" + pointAverage;
    }
}
