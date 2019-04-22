package com.geekbrains.project.dao;

import com.geekbrains.project.dto.Speciality;

public interface SpecialityDao {
    Speciality getAvgMarkBySpec(String title);
}
