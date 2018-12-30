package com.springmybatis.dao;
import com.springmybatis.entity.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {

    /**
     * 添加学生
     *
     * @return
     */
    int insertStudent(Student student);


    int updateStudent(Student student);

    /**
     * 删除一名学生
     * @param id
     * @return
     */
    int deleteStudent(Integer id);

    /**
     * 根据学生线上学号与姓名查询学生信息
     * @param
     * @return
     */
    List<Student> selectOnselectUserByLineIdAndName(HashMap<String,Object> map);

    /**
     * 查询全表
     * @return
     */
    List<Student> selectAll();

}
