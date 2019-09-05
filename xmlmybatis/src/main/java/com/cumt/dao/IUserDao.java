package com.cumt.dao;

import com.cumt.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据条件模糊查询
     * @param user
     * @return
     */
    List<User> findByCondition(User user);

    /**
     * insert用户信息
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新数据
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据Id删除数据
     * @param id
     */
    void deleteUser(int id);
}
