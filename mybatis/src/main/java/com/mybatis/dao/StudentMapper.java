package com.mybatis.dao;

import com.mybatis.entity.Student;

import java.util.HashMap;
import java.util.List;


public interface StudentMapper {

    int insert(Student student);
    int update(Student student);
    int delete(Integer id);
    List<Student> selectAll();
    List<Student> selectUserByLineIdAndName(HashMap<String,Object> map);
}
