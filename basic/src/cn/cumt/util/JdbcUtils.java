package cn.cumt.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String drive;
    private static String url;
    private static String user;
    private static String password;


    /**
     * 加载properties注册驱动
     */
    static{

        try {

            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL resourceUrl = classLoader.getResource("jdbc.properties");//src下的路径
            String path = resourceUrl.getPath();

            Properties jdbcProperties = new Properties();
            jdbcProperties.load(new FileReader(path));
            drive = jdbcProperties.getProperty("drive");
            url = jdbcProperties.getProperty("url");
            user = jdbcProperties.getProperty("user");
            password = jdbcProperties.getProperty("password");

            Class.forName(drive);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    /**
     * 获取连接对象
     * @return 连接的对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        return  DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭资源
     * @param statement 执行Sql的对象
     * @param connection 连接对象
     */
    public static void close(Statement statement,Connection connection){

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
     * 关闭资源
     * @param resultSet 结果集对象
     * @param statement 执行sql的对象
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


}
