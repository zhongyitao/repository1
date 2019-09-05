package com.cumt.enterprise.dao;

import com.cumt.enterprise.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from users")
    @Results({@Result(id = true, property = "id", column = "ID"),
              @Result(property = "email", column = "EMAIL"),
              @Result(property = "username", column = "USERNAME"),
              @Result(property = "password", column = "PASSWORD"),
              @Result(property = "phoneNum", column = "PHONENUM"),
              @Result(property = "status", column = "STATUS"),
              @Result(property = "roles", column = "ID", javaType = List.class, many = @Many(select = "com.cumt.enterprise.dao.RoleDao.findByUserId")),
    })
    public List<UserInfo> findAll();

    @Select("select * from users where username = #{username}")
    @Results({@Result(id = true, property = "id", column = "ID"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "phoneNum", column = "PHONENUM"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "roles", column = "ID", javaType = List.class, many = @Many(select = "com.cumt.enterprise.dao.RoleDao.findByUserId")),
    })
    public UserInfo findByUsername(String username);
}
