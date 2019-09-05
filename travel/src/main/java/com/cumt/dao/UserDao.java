package com.cumt.dao;

import com.cumt.domain.User;

public interface UserDao {

    /**
     * 根据用户名查找用户数据
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 注册，新增一个用户信息
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 根据激活码查询数据
     * @param code
     * @return
     */
    User findUserByCode(String code);

    /**
     * 修改激活状态
     * @param user
     * @return
     */
    boolean updateStatus(User user);

    /**
     * 根据用户名密码查询用户信息
     * @param user
     * @return
     */
    User findUserByUsernameAndPassword(User user);
}
