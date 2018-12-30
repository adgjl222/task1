package com.springmybatis.service;

import com.springmybatis.dao.StudentMapper;
import com.springmybatis.entity.Student;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class StudentServiceImpl {
    ApplicationContext applicationContext = null;
    //获得bean
    StudentMapper studentMapper = null;
    static Logger log = Logger.getLogger(StudentServiceImpl.class);

    /**
     * 添加一名学生
     * @param student
     * @return
     */
    public int insertStudent(Student student) {
        int a = 0;
        try {
            applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            studentMapper = applicationContext.getBean(StudentMapper.class);
            a = studentMapper.insertStudent(student);
            if (a > 0) {
                System.out.println("成功添加"+a+"条数据:"+student.toString()+"所添加数据的主键为"+student.getId());
                log.info(student.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("数据添加失败");
//            System.out.println("数据添加失败");
        }
        return a;
    }



    /**
     * 更新一条数据
     * @param student
     * @return
     */

    public boolean updateStudent(Student student) {
        boolean update = false;
        int a = 0;
        try {
            applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            studentMapper = applicationContext.getBean(StudentMapper.class);
            a = studentMapper.updateStudent(student);
            if (a != 0) {
                update = true;
                log.info("数据更新成功");

            }else {
                update = false;
                log.info("数据更新失败");
            }
        }catch (Exception e) {
            e.printStackTrace();

        }

        return update;
    }

    /**
     * 删除一名学生
     * @param id
     * @return
     */
    public boolean deleteStudent(Integer id) {
        boolean delete = false;
        try {
            applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            studentMapper = applicationContext.getBean(StudentMapper.class);
            int a = studentMapper.deleteStudent(id);
            if (a != 0) {
                delete = true;
                log.info("数据删除"+delete);
            }else {
                delete = false;
                log.info("数据删除"+delete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;

    }



    /**
     * 根据学生线上学号与姓名查询学生信息
     * @return
     */
    public List<Student> selectOne(HashMap<String,Object> map) {
        List<Student> list =  null;
        try {
            applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            studentMapper = applicationContext.getBean(StudentMapper.class);
            list = studentMapper.selectOne(map);
            if (list != null){
                log.info(list);

            }else {
                log.info("查无此人");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询全表
     *
     * @return
     */
    public List <Student> selectAll() {
        applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        studentMapper = applicationContext.getBean(StudentMapper.class);

        //访问数据库
        List<Student> students = studentMapper.selectAll();
        for (Student student:students){
            log.info(student);

        }
        return null;
    }

}

