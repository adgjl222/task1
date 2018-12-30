package com.jdbctemplate.main;


import com.jdbctemplate.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class M {
    public static void main(String[] args) {

        //创建Spring实例
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        //创建jdbcTemplate
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //创建sql语句
        String sql = "SELECT * FROM student";

        //创建Mapper.BeanPropertyRowMapper传入对象类，会自动映射结果
        RowMapper <Student> mapper = new BeanPropertyRowMapper <>(Student.class);


        List <Student> students = jdbcTemplate.query(sql, mapper);

        for (Student i : students) {
            System.out.println(i);
        }

    }
}
