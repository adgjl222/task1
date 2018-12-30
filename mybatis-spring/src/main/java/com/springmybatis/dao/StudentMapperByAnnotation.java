package com.springmybatis.dao;

import com.springmybatis.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;


public interface StudentMapperByAnnotation {

    /**
     * 添加单条数据
     * @param student
     * @return
     */
    @Insert("INSERT INTO student(line_id,name,qq,type,estimated_time,graduate_from,logURL,will,senior,know_from,created_at,updated_at) " +
            "VALUES(#{lineId},#{name},#{qq},#{type},#{estimatedTime},#{graduateFrom},#{logUrl},#{will},#{senior},#{knowFrom},#{createdAt},#{updatedAt})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertStudent(Student student);

    /**
     * 更新单条数据
     * @param student
     * @return
     */
    @Update("UPDATE student SET type=#{type},senior= #{senior} WHERE line_id = #{lineId}")
    int updateStudent(Student student);

    /**
     * 删除单条数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM student WHERE  ID = #{id}")
    int deleteStudent(int id);


    /**
     * 查询全表
     * @return
     */
   @Select(" SELECT * FROM student")
   List<Student> selectAll();


    /**
     * 根据学生姓名、线上学号查询学生报名帖
     * @param map
     * @return
     */
    @Select("SELECT *FROM student WHERE line_id = #{lineId} and name = #{name}")
    List<Student> selectUserByLineIdAndName(HashMap <String, Object> map);

}
