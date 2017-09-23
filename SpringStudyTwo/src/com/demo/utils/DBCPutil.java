package com.demo.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 描述:
 * DBCP获取连接的工具类
 *
 * @outhor MrJ
 * @create 2017-09-23 11:33
 */
public class DBCPutil {
    //定义数据源对象
    private static DataSource ds = null;

    //使用静态代码块给数据源对象赋值
    static {
        InputStream in = null;
        try {
            Properties properties = new Properties();
            in = DBCPutil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            properties.load(in);
            ds = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化连接失败！");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
