package com.mybatis.service;

import com.mybatis.dao.StudentMapper;
import com.mybatis.entity.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.mybatis.util.MybatisUtil;

import java.util.HashMap;
import java.util.List;

public class StudentServiceImpl {

    SqlSession session = null;
    StudentMapper mapper = null;
    static Logger log = Logger.getLogger(StudentServiceImpl.class);

    /**
     * 添加单条数据
     *
     * @param student
     * @return
     */

    public int isnert(Student student) {
        int a = 0;
        try {
            session = MybatisUtil.creatSqlSession();
            mapper = session.getMapper(StudentMapper.class);
            a = mapper.insert(student);
            if (a > 0) {
                session.commit();
                log.info("成功添加" + a + "条数据:" + student.toString() + "所添加数据的主键为" + student.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            log.info("数据添加失败");
        }
        if (session != null) session.close();


        return a;
    }

    /**
     * 更新一条数据
     *
     * @param student
     * @return
     */

    public boolean update(Student student) {
        boolean update = false;
        int a = 0;
        try {
            session = MybatisUtil.creatSqlSession();
            mapper = session.getMapper(StudentMapper.class);
            a = mapper.update(student);
            if (a != 0) {
                update = true;
                session.commit();
                log.info("数据更新成功");
            } else {
                update = false;
                log.info("数据更新失败");
            }
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();

        }
        if (session != null) session.close();

        return update;
    }

    /**
     * 删除单条数据
     *
     * @param id
     * @return
     */

    public boolean delete(Integer id) {
        boolean delete = false;
        int a = 0;
        try {
            session = MybatisUtil.creatSqlSession();
            mapper = session.getMapper(StudentMapper.class);
            a = mapper.delete(id);
            if (a != 0) {
                delete = true;
                session.commit();
                log.info("数据删除成功");
            } else {
                delete = false;
                log.info("数据删除失败");
            }
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
        if (session != null) session.close();
        return false;
    }


    /**
     * 查询全表信息
     *
     * @return
     */

    public List <Student> selectAll() {
        List <Student> list = null;
        try {
            session = MybatisUtil.creatSqlSession();
            mapper = session.getMapper(StudentMapper.class);
            list = mapper.selectAll();
            log.info("报名表全部信息为：" + list);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
        if (session != null) session.close();

        return list;
    }

    /**
     * 根据学生姓名、学号查询数据
     */
    public List <Student> selectUserByLineIdAndName(HashMap <String, Object> map) {

        try {
            session = MybatisUtil.creatSqlSession();
            mapper = session.getMapper(StudentMapper.class);
            List <Student> list = mapper.selectUserByLineIdAndName(map);
            if (list != null) {
                log.info(list);
                System.out.println(list);
            } else {
                log.info("查无此人");
            }
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
        if (session != null) session.close();
        return null;
    }


}
