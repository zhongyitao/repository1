package com.cumt.dao;

import com.cumt.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有数据
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, property = "id", column = "ID"),
            @Result(property = "uid", column = "UID"),
            @Result(property = "money", column = "MONEY"),
            @Result(property = "user", column = "uid", one = @One(select = "com.cumt.dao.IUserDao.findById"))
    })
    List<Account> findAll();

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    Account findById(int id);

    /**
     * 根据uid查询数据
     * @param uid
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    List<Account> findByUid(int uid);



}
