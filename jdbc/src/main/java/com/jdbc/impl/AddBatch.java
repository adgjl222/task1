package com.jdbc.impl;

import com.jdbc.util.JdbcUtil;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBatch {
    public static void main(String[] args) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pst = null;
        Long a = System.currentTimeMillis();
        try {

            conn.setAutoCommit(false);
            String sql = "INSERT INTO student(line_id,name,qq,type,graduate_from,logURL,will,senior,know_from)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
//            for (int i = 0; i <= 20000;i++) {
                for (int j = 1; j <= 100; j++) {
                    pst.setInt(1, 2585);
                pst.setString(2, "张批量");
                pst.setInt(3, 3565);
                pst.setString(4, "java");
                pst.setString(5, "工大");
                pst.setString(6, "dfhsjdfhj");
                pst.setString(7, "天");
                pst.setString(8, "湖批量");
                pst.setString(9, "知乎");
                pst.addBatch();
            }

                pst.executeBatch();
                pst.clearBatch();
                conn.commit();


//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Long b = System.currentTimeMillis();
            System.out.println("MySql批量插入2亿条记录用时"+ (b-a)+" ms");
            JdbcUtil.releaseResources(null, pst, conn);
        }

    }
}
