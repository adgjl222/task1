package com.jdbctemplate.impl;

import com.jdbctemplate.dao.StudentDao;
import com.jdbctemplate.entity.Student;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;


@Repository
public class StudentDaoImpl  implements StudentDao {
    private JdbcTemplate jdbcTemplate;
//    //spring为我么提供了JdbcDaoSuppor支持类，所有Dao继承这个类 可以自动获得JdbcTemplate（前提是注入datasource）
//    //继承此类后在，在接口实现类就不用再使用构造器去获取JdbcTemplate
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    static Logger log = Logger.getLogger(StudentDaoImpl.class);

    @Override
    public int insertStudent(final Student student) throws SQLException,ParseException {

        final String sql = "INSERT INTO student(line_id,name,qq,type,graduate_from,logURL,will,senior,know_from)" + "VALUES(?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, student.getLineId());
                ps.setString(2, student.getName());
                ps.setInt(3, student.getQq());
                ps.setString(4, student.getType());
                ps.setString(5, student.getGraduateFrom());
                ps.setString(6, student.getLogUrl());
                ps.setString(7, student.getWill());
                ps.setString(8,student.getSenior());
                ps.setString(9, student.getKnowFrom());
                return ps;
            }

        }, keyHolder);
        log.info("插入数据的主键为"+keyHolder.getKey().intValue());
//        log.info("插入数据的主键为"+keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }


    @Override
    public boolean updateStudent(String name, Integer lineId) {

        int i = 0;
        try {
            String sql = "UPDATE student SET name =? WHERE line_id =?";
            log.info(jdbcTemplate);
            i = jdbcTemplate.update(sql,name,lineId);
            if (i != 0){
                log.info("数据更新成功");
            }else {
                log.info("数据更新失败");
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return i>0?true:false;
    }

    @Override
    public boolean deleteStudent(Integer id) {

        String sql = "DELETE FROM student WHERE ID = ?";
        int delete = jdbcTemplate.update(sql,id);
        if (delete != 0){
        log.info("数据删除成功");}
        else {
            log.info("数据删除失败");
        }

        return false;
    }

    @Override
    public List<Student> selectUserByLineIdAndName( String name,  Integer lineId) {

        String sql= "select * from student where name=? and line_id = ?";
        Student student = jdbcTemplate.queryForObject(sql,new Object[]{name,lineId},new BeanPropertyRowMapper<>(Student.class));
        log.info(student);
        return null;


    }

    @Override
    public List <Student> selectAll() {
        String sql = "SELECT * FROM student";
        RowMapper<Student> mapper = new BeanPropertyRowMapper<>(Student.class);

        List<Student> list = jdbcTemplate.query(sql,mapper);
        for (Student student:list){
            log.info(student);
        }
        return null;
    }


}
