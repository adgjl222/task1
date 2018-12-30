package com.jdbctemplate.dao;

import com.jdbctemplate.entity.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface StudentDao  {

     int insertStudent(Student student)throws SQLException,ParseException;
     boolean updateStudent(String name,Integer lineId);
     boolean deleteStudent(Integer id);
     List<Student> selectUserByLineIdAndName(String name,Integer lineId);
     List<Student> selectAll();



}
