package cn.cumt.practice;

import cn.cumt.bean.User;
import cn.cumt.util.JDBCUtils2;
import cn.cumt.util.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class JdbcTest {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        boolean f = new JdbcTest().login(userName,password);
        if (f)
        {
            System.out.println("登陆成功！");
        }else
        {
            System.out.println("用户名或密码错误！");

        }
    }


    public boolean login(String userName , String password){

        if(null == userName || null == password )
        {
            return  false;
        }

        Connection connection = null;
        //Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            connection= JdbcUtils.getConnection();
            String sql = "select username, password from user where username = ? and password = ?";
            //System.out.println(sql);
            //statement = connection.createStatement();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            connection.commit();
            return resultSet.next();
        } catch (Exception e) {
            if (null != connection){
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,preparedStatement,connection);
        }
        return false;
    }



    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils2.getDataSource());

    @Test
    public void druidTest() {
        String sql = "insert into user values(NULL,?,?)";
        jdbcTemplate.update(sql,"孙七","33333");
    }

    @Test
    public void druidTest1() {
        String sql = "SELECT * FROM USER";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
