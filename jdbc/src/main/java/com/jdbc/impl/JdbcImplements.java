package com.jdbc.impl;

import com.jdbc.dao.JdbcDao;
import com.jdbc.entity.Student;
import com.jdbc.util.JdbcUtil;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class JdbcImplements implements JdbcDao {
    private Connection conn = null;
    private PreparedStatement pst;
    private ResultSet rst;


    static Logger log = Logger.getLogger(JdbcImplements.class);

    /**
     * 添加单条数据
     * @param student
     */
    @Override
    public int insert(Student student) {
       int i = 0;
        try {
            //Statement.RETURN_GENERATED_KEY能获取自动生成的键值
            conn = JdbcUtil.getConnection();
            String sql = " INSERT INTO student(line_id,name,qq,type,estimated_time,graduate_from,logURL,will,senior,know_from,created_at,updated_at)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1,student.getLineId());
            pst.setString(2,student.getName());
            pst.setInt(3,student.getQq());
            pst.setString(4,student.getType());
            pst.setLong(5,student.getEstimatedTime());
            pst.setString(6,student.getGraduateFrom());
            pst.setString(7,student.getLogUrl());
            pst.setString(8,student.getWill());
            pst.setString(9,student.getSenior());
            pst.setString(10,student.getKnowFrom());
            pst.setLong(11,student.getCreatedAt());
            pst.setLong(12,student.getUpdatedAt());

            i = pst.executeUpdate();
            //得到插入记录的id
            rst = pst.getGeneratedKeys();

            if(rst.next()){
                int id = rst.getInt(1);
                log.info("插入数据的主键值为"+id);
            }
            JdbcUtil.releaseResources(rst,pst,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;

    }
    /**
     * 更新单条数据
     * @param name
     * @param lineId
     * @return
     */
    @Override
    public boolean update(Integer lineId,String name) {
        boolean update = false;
        conn =JdbcUtil.getConnection();
        String sql = "UPDATE student SET name = ? where line_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,name );
            pst.setInt(2,lineId);

            int a =  pst.executeUpdate();//用于执行update、insert、delete语句

            if (a != 0){
                update = true;
                log.info("数据更新成功");
            }

            else {
                update = false;
                log.info("数据更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseResources(null, pst, conn);
        }
        return update;
    }



    /**
     * 删除单条数据
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        boolean delete = false;
       conn =JdbcUtil.getConnection();
        String sql = "DELETE FROM student WHERE ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int a =  pst.executeUpdate();
            log.info(a);
            if (a != 0){
                delete = true;
                log.info("数据删除成功");
            }
            else {
                delete = false;
                log.info("数据删除失败");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseResources(null, pst, conn);

        }

        return delete;
    }

    /**
     * 根据线上学号和姓名查询报名表信息
     * @param lineId
     * @param name
     * @return
     */
    @Override
    public List <Student>selectUserByLineIdAndName(Integer lineId,String name) {
        conn =JdbcUtil.getConnection();
        String sql = "SELECT * FROM student WHERE line_id =? and name =? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,lineId);
            pst.setString(2,name);
            rst = pst.executeQuery();
            if (rst.next()){
                Student student = new Student();
                student.setName(rst.getString("name"));
                student.setLineId(rst.getInt("lineId"));
                student.setQQ(rst.getInt("qq"));
                student.setType(rst.getString("type"));
                student.setEstimatedTtime(rst.getLong("estimated_time"));
                student.setGraduate_from(rst.getString("graduate_from"));
                student.setLogURL(rst.getString("logURL"));
                student.setWill(rst.getString("will"));
                student.setSenior(rst.getString("senior"));
                student.setKnowFrom(rst.getString("know_from"));

                log.info(student);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseResources(rst,pst,conn);
        }


        return null;
    }

    /**
     * 查询全表
     * @return
     */
    @Override
    public List<Student> selectAll() {

        List<Student>list  = new ArrayList <>();
        try {

            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM student";
            log.info("sql = " + sql);
            pst = conn.prepareStatement(sql);
            log.info("sql = " + pst);
            rst = pst.executeQuery();//用于执行select语句
            while (rst.next()) {
                Student student = new Student();
                student.setName(rst.getString("name"));
                        student.setLineId(rst.getInt("line_id"));
                        student.setQQ(rst.getInt("qq"));
                        student.setType(rst.getString("type"));
                        student.setEstimatedTtime(rst.getLong("estimated_time"));
                        student.setGraduate_from(rst.getString("graduate_from"));
                        student.setLogURL(rst.getString("logURL"));
                        student.setWill(rst.getString("will"));
                        student.setSenior(rst.getString("senior"));
                        student.setKnowFrom(rst.getString("know_from"));

                list.add(student);
                log.info(list);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JdbcUtil.releaseResources(rst,pst,conn);
        }
        return null;
    }


}


