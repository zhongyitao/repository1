package com.cumt.springbootdemo1.dao;

import com.cumt.springbootdemo1.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Select("select * from user")
    public List<User> findAll();
}
