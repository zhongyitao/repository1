package cn.cumt.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils2 {

    private static DataSource dataSource = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils2.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池
     * @return 数据库连接池
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取数据库连接对象
     * @return 数据库连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     * @param resultSet 结果对象
     * @param statement 执行sql对象
     * @param connection 连接对象
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){

        if (null != resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != statement){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 释放资源
     * @param statement 执行sql对象
     * @param connection 连接对象
     */
    public static void close(Statement statement, Connection connection){

        close(null,statement,connection);

    }



}
