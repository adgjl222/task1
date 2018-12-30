package com.jdbc.dao;

import com.jdbc.entity.Student;

import java.util.List;

public interface JdbcDao {
    int insert(Student student);
    boolean update(Integer lineId,String name);
    boolean delete(Integer id);
    List<Student> selectUserByLineIdAndName(Integer lineId,String name);
    List<Student> selectAll();

}
