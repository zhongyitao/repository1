package cn.cumt.jdbc;

import cn.cumt.util.JdbcUtils;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "UPDATE stu SET score = 100 WHERE id = 1";
            String sql1 = "insert into stu values(4,'林平之',45,85,null,NULL)";
            String sql2 = "select * from stu";

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql2);

            while(resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double score = resultSet.getDouble("score");
                Timestamp intert_time = resultSet.getTimestamp("intert_time");
                System.out.println(id+"----"+name+"---"+age+"---"+score+"----"+intert_time);


            }


            //int count = statement.executeUpdate(sql1);
            /*System.out.println(count);
            if (count >0 ){
                System.out.println("sql执行成功了！");
            }else {
                System.out.println("sql执行失败了！");
            }
*/




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,statement,connection);
        }




    }

}
