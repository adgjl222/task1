package com.springmybatis;

import com.springmybatis.entity.Student;
import com.springmybatis.service.StudentServiceImpl;
import org.junit.Test;

import java.util.HashMap;

public class StudentTest {
    StudentServiceImpl studentService = new StudentServiceImpl();

    /**
     * 添加单条数据
     */
    @Test
    public void testInsert(){
        Student student = new Student();
        student.setLineId(8988);
        student.setName("莫文蔚");
        student.setQQ(758458439);
        student.setType("java");
        student.setName("测试");
        student.setWill("爱拼才会赢");
        student.setSenior("李诞");
        student.setKnowFrom("知乎");
        student.setGraduate_from("河南工业大学");
        student.setLogURL("http://www.jnshu.com/school/24388/daily?page=1&orderBy=3&sort=1");
        try {
            studentService.insertStudent(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单条数据更新
     */
    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setType("WEB");
        student.setSenior("刘能");
        student.setLineId(8437);
        studentService.updateStudent(student);

    }

    /**
     * 单条数据删除
     */
    @Test
    public void testDelete(){
        studentService.deleteStudent(100);
    }


    /**
     * 根据学生姓名、线上学号查询学生信息
     */
    @Test
    public void testSelectOne(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name","刘文");
        map.put("line_id",2587);
        studentService.selectOne(map);

    }

    /**
     * 查询全表
     */
    @Test
    public void testSelectAll(){
        studentService.selectAll();
    }


}

