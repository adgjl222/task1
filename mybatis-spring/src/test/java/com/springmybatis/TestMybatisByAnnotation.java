package com.springmybatis;

import com.springmybatis.dao.StudentMapperByAnnotation;
import com.springmybatis.entity.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;


public class TestMybatisByAnnotation {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");;
    //获得bean
    StudentMapperByAnnotation studentMapper = applicationContext.getBean(StudentMapperByAnnotation.class);
    static Logger log = Logger.getLogger(TestMybatisByAnnotation.class);
    @Test
    public void testInsert(){
        Student student = new Student();
        student.setLineId(7032);
        student.setQQ(758458439);
        student.setType("java");
        student.setName("测试");
        student.setWill("爱拼才会赢");
        student.setSenior("李诞");
        student.setKnowFrom("知乎");
        student.setGraduate_from("河南工业大学");
        student.setLogURL("http://www.jnshu.com/school/24388/daily?page=1&orderBy=3&sort=1");
        try {
            int insert = studentMapper.insertStudent(student);
            if (insert > 0){
                log.info(insert+"条数据添加成功"+"，插入数据的主键为"+student.getId());
            }else {
                log.info("数据添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testUpdate(){
        boolean update = false;
        Student student = new Student();
        student.setSenior("王建国");
        student.setLineId(8411);
        student.setType("UI");
        int a = 0;
        try {
            a = studentMapper.updateStudent(student);
            if (a == 1){
                update = true;
                log.info("数据更新成功");
            }
            else {
                update = false;
                log.info("数据更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDelete(){
        boolean delete = false;
        int a = 0;
        try {
            a= studentMapper.deleteStudent(7);
            if (a == 1){
                delete = true;
                log.info("数据删除"+delete);
            }
            else {
                delete = false;
                log.info("数据删除"+delete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void selectUserByLineIdAndName(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name","刘");
        map.put("lineId",2585);
        List<Student> list = studentMapper.selectUserByLineIdAndName(map);
        log.info(list);
    }

    @Test
    public void testSelectAll(){
        List<Student> list = studentMapper.selectAll();
        log.info(list);
    }

}
