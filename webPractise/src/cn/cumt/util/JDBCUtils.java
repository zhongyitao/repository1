package cn.cumt.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {


    private static DataSource dataSource;

    static {
        Properties druidPro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("./druid.properties");
        try {
            druidPro.load(is);

            dataSource = DruidDataSourceFactory.createDataSource(druidPro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DataSource getDataSource(){
        return dataSource;
    }

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
