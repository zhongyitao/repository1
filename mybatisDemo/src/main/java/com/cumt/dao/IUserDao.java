package com.cumt.dao;

import com.cumt.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
