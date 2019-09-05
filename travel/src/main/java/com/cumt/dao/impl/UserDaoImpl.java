package com.cumt.dao.impl;

import com.cumt.dao.UserDao;
import com.cumt.domain.User;
import com.cumt.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名查找用户数据
     *
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        User user = null;

        String sql = "select * from tab_user where username = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 注册，新增一个用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {

        String sql = "insert into tab_user (username,password,name,sex,birthday,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, user.getUsername(),
                user.getPassword(), user.getName(),
                user.getSex(), user.getBirthday(),
                user.getTelephone(), user.getEmail(),
                user.getStatus(), user.getCode());
        return update > 0;
    }

    /**
     * 根据激活码查询数据
     *
     * @param code
     * @return
     */
    @Override
    public User findUserByCode(String code) {
        String sql = "select * from tab_user where code = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 修改激活状态
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where code = ?";
        int i = 0;
        try {
            i = jdbcTemplate.update(sql, user.getCode());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return i > 0;
    }

    /**
     * 根据用户名密码查询用户信息
     *
     * @param user
     * @return
     */
    @Override
    public User findUserByUsernameAndPassword(User user) {
        String sql = "select * from tab_user where username = ? and password = ?";
        User u = null;
        try {
            u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return u;
    }
}
