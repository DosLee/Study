package com.demo.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 描述:
 * 事务管理工具
 *
 * @outhor MrJ
 * @create 2017-09-23 12:27
 */
public class TransactionManager {
    //定义一个线程局部变量
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //获取连接只能使用此方法
    public static Connection getConnection(){
        Connection conn = tl.get();
        if (conn == null){
            tl.set(DBCPutil.getConnection());
        }
        return tl.get();
    }
    public static void startTransaction(){
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit(){
        Connection conn = getConnection();
        try {
                conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //回滚事务
    public static void rollback(){
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public static void release(){
        Connection conn = getConnection();
        try {
            conn.close();
            tl.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
