package com.geekbrains.project;

import com.geekbrains.project.dao.SpecialityDao;
import com.geekbrains.project.dao.StudentDao;
import com.geekbrains.project.dao.impl.SpecialityDaoImpl;
import com.geekbrains.project.dao.impl.StudentDaoImpl;
import com.geekbrains.project.dto.Student;
import com.geekbrains.project.txt.ReaderWriter;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final static String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = new StudentDaoImpl();
        SpecialityDao specialityDao = new SpecialityDaoImpl();
        int id;
        String firstName;
        String lastName;
        String middleName;
        String speciality;
        double pointAverage;
        List<Student> list;
        while (true) {
            System.out.println("Enter command:");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case ("/help"):
                    System.out.println("Commands:");
                    System.out.println("/getAll");
                    System.out.println("/selectByLastName");
                    System.out.println("/update");
                    System.out.println("/insert");
                    System.out.println("/delete");
                    System.out.println("/selectAllBySpec");
                    System.out.println("/exportToDB");
                    System.out.println("/exportFromDB");
                    System.out.println("/getAvgMarkBySpec");
                    System.out.println("/exit");
                    break;
                case ("/getAll"):
                    studentDao.getAllStudents();
                    break;
                case ("/selectByLastName"):
                    System.out.println("Enter lastName:");
                    String lname = scanner.nextLine();
                    studentDao.getStudent(lname);
                    break;
                case ("/update"):
                    System.out.println("Enter id:");
                    id = scanner.nextInt();
                    System.out.println("Enter firstName:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter lastName:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter middleName:");
                    middleName = scanner.nextLine();
                    System.out.println("Enter speciality:");
                    speciality = scanner.nextLine();
                    System.out.println("Enter pointAverage:");
                    pointAverage = scanner.nextDouble();
                    studentDao.update(new Student(id, firstName, lastName, middleName, speciality, pointAverage));
                    break;
                case ("/insert"):
                    System.out.println("Enter firstName:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter lastName:");
                    lastName = scanner.nextLine();
                    System.out.println("Enter middleName:");
                    middleName = scanner.nextLine();
                    System.out.println("Enter speciality:");
                    speciality = scanner.nextLine();
                    System.out.println("Enter pointAverage:");
                    pointAverage = scanner.nextDouble();
                    studentDao.insert(new Student(firstName, lastName, middleName, speciality, pointAverage));
                    break;
                case ("/delete"):
                    System.out.println("Enter id:");
                    id = scanner.nextInt();
                    studentDao.deleteById(id);
                    break;
                case ("/selectAllBySpec"):
                    System.out.println("Enter speciality:");
                    speciality = scanner.nextLine();
                    studentDao.getStudentsBySpec(speciality);
                    break;
                case ("/exportToDB"):
                    list = ReaderWriter.reader(FILE_PATH);
                    studentDao.exportToDB(list);
                    break;
                case ("/exportFromDB"):
                    list = studentDao.getAllStudents();
                    ReaderWriter.writer(FILE_PATH, list);
                    break;
                case ("/getAvgMarkBySpec"):
                    System.out.println("Enter title speciality:");
                    speciality = scanner.nextLine();
                    specialityDao.getAvgMarkBySpec(speciality);
                    break;
                case ("/exit"):
                    return;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }
}
