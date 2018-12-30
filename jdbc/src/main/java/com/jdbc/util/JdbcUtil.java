package com.jdbc.util;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JdbcUtil {
    /**
     * 通过建立工具类将数据库的驱动加载、获取连接、资源释放独立出来以达到复用目的
     * 步骤：
     * 1、建立包含数据库url、username、password的properties文件(见dbinfo.properties)
     * 2、加载配置文件内容读取到数据库信息
     * 3、将配置文件中的url等信息提取出来
     * 4、加载驱动
     * 5、获取连接
     * 6、释放资源
     */

    private static String url;
    private static String user;
    private static String password;

    //加载配置文件内容
    static{
        try {
            //加载dbinfo.properties配置文件
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties pt = new Properties();
            pt.load(in);

            //获取数据库url等信息
            url = pt.getProperty("url");
            user = pt.getProperty("user");
            password = pt.getProperty("password");

            //加载驱动
            String Driver = "com.mysql.jdbc.Driver";
            Class.forName(Driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源
    public static void releaseResources(ResultSet rst, PreparedStatement pst, Connection  conn){
        try {
            if (rst != null)
                rst.close();//如果结果集不为空 关闭结果集
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rst = null;//结果集为空
        }
        try {
            if (pst != null)
                pst.close();//
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pst = null;
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn = null;
        }
    }
}
