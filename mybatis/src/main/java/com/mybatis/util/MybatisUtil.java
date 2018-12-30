package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;


public class MybatisUtil {
    //使用SqlSessionFactoryBuilder()创建SqlSessionFactory实例
    //类加载时执行静态块，静态块只执行一次，以后不再执行
     private static SqlSessionFactory sqlSessionFactory;
     static {
         try {
             //加载mybatis-config.xml配置文件
             InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
             sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     //使用SqlSessionFactory创建SqlSession
    public static SqlSession creatSqlSession(){
         return sqlSessionFactory.openSession();
    }

}
