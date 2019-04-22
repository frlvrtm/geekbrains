package com.geekbrains.project.dao.impl;

import com.geekbrains.project.config.DataConfig;
import com.geekbrains.project.dao.StudentDao;
import com.geekbrains.project.dto.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static final String SQL_UPDATE =
            "UPDATE Students SET first_name = ?, " +
                    "second_name = ?, " +
                    "middle_name = ?, " +
                    "speciality = ?, " +
                    "point_average = ? " +
                    "WHERE id = ?";
    private static final String SQL_INSERT =
            "INSERT INTO Students (first_name, second_name, middle_name, speciality, point_average) " +
                    "VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_LNAME =
            "SELECT st.id, " +
                    "st.first_name, " +
                    "st.second_name, " +
                    "st.middle_name, " +
                    "sp.title as speciality, " +
                    "st.point_average " +
                    "FROM Students st LEFT JOIN Speciality sp ON sp.id = st.speciality " +
                    "WHERE st.second_name LIKE ?";
    private static final String SQL_FIND_ALL =
            "SELECT st.id, " +
                    "st.first_name, " +
                    "st.second_name, " +
                    "st.middle_name, " +
                    "sp.title as speciality, " +
                    "st.point_average " +
                    "FROM Students st INNER JOIN Speciality sp ON sp.id = st.speciality " +
                    "ORDER BY st.id";
    private static final String SQL_FIND_BY_SPEC =
            "SELECT st.id, st.first_name, " +
                    "st.second_name, " +
                    "st.middle_name, " +
                    "sp.title as speciality, " +
                    "st.point_average " +
                    "FROM Students st LEFT JOIN Speciality sp ON sp.id = st.speciality " +
                    "WHERE sp.title LIKE ? " +
                    "ORDER BY st.id";
    private static final String SQL_DELETE =
            "DELETE FROM Students WHERE id = ?";

    private DataConfig dataConfig = new DataConfig();
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private final static Logger logger = Logger.getLogger(StudentDaoImpl.class);

    @Override
    public Student getStudent(String lname) {
        Student student = null;
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_LNAME);
            statement.setString(1, "%" + lname + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("second_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setSpeciality(resultSet.getString("speciality"));
                student.setPointAverage(resultSet.getDouble("point_average"));
            }
            logger.info(student);
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
        return student;
    }

    @Override
    public void update(Student student) {
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getMiddleName());
            statement.setInt(4, Integer.parseInt(student.getSpeciality()));
            statement.setDouble(5, student.getPointAverage());
            statement.setInt(6, student.getId());
            statement.executeUpdate();
            logger.info("Accepted! data successfully saved!");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
    }

    @Override
    public void insert(Student student) {
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getMiddleName());
            statement.setInt(4, Integer.parseInt(student.getSpeciality()));
            statement.setDouble(5, student.getPointAverage());
            statement.executeUpdate();
            logger.info("Accepted! data successfully saved!");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
    }

    @Override
    public void deleteById(int id) {
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();
            logger.info("Student with ID = " + id + " deleted!");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("second_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setSpeciality(resultSet.getString("speciality"));
                student.setPointAverage(resultSet.getDouble("point_average"));
                students.add(student);
            }
            logger.info(toString(students));
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
        return students;
    }

    @Override
    public List<Student> getStudentsBySpec(String title) {
        List<Student> students = new ArrayList<>();
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_SPEC);
            statement.setString(1, "%" + title + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("second_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setSpeciality(resultSet.getString("speciality"));
                student.setPointAverage(resultSet.getDouble("point_average"));
                students.add(student);
            }
            logger.info(toString(students));
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
        return students;
    }

    @Override
    public void exportToDB(List<Student> list) {
        connection = null;
        try {
            connection = dataConfig.getConnection();
            for (Student s : list) {
                statement = connection.prepareStatement(SQL_INSERT);
                statement.setString(1, s.getFirstName());
                statement.setString(2, s.getLastName());
                statement.setString(3, s.getMiddleName());
                statement.setInt(4, Integer.parseInt(s.getSpeciality()));
                statement.setDouble(5, s.getPointAverage());
                statement.executeUpdate();
            }
            logger.info("Accepted! data successfully saved!");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
    }

    @Override
    public String toString(List<Student> list) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Students:").append("\n");
        for (Student student : list) {
            builder.append(student.toString()).append("\n");
        }
        return builder.toString();
    }
}
