package com.geekbrains.project.dao.impl;

import com.geekbrains.project.config.DataConfig;
import com.geekbrains.project.dao.SpecialityDao;
import com.geekbrains.project.dto.Speciality;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialityDaoImpl implements SpecialityDao {
    private static final String SQL_SELECT_AVG_MARK_BY_SPEC =
            "SELECT sp.id, sp.title, AVG(st.point_average) as avg " +
                    "FROM Speciality sp INNER JOIN Students st ON st.speciality = sp.id " +
                    "WHERE sp.title LIKE ? ";

    private DataConfig dataConfig = new DataConfig();
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private final static Logger logger = Logger.getLogger(SpecialityDaoImpl.class);

    @Override
    public Speciality getAvgMarkBySpec(String title) {
        Speciality speciality = null;
        connection = null;
        try {
            connection = dataConfig.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_AVG_MARK_BY_SPEC);
            statement.setString(1, "%" + title + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                speciality = new Speciality();
                speciality.setId(resultSet.getInt("id"));
                speciality.setTitle(resultSet.getString("title"));
                speciality.setDescription(resultSet.getString("avg"));
            }
            logger.info(speciality);
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            dataConfig.closeConnection(connection);
        }
        return speciality;
    }
}
