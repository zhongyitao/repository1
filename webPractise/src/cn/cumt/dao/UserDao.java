package cn.cumt.dao;

import cn.cumt.domain.User;
import cn.cumt.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private  JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){

        User result = null;
        try {
            String sql = "select * from user where username = ? and password = ?";
            result = (User) jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }



}
