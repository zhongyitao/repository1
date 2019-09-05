package com.cumt.dao;

import com.cumt.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有数据
     * @return
     */
    List<Account> findAll();

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Account findById(int id);

    /**
     * 根据uid查询数据
     * @param uid
     * @return
     */
    List<Account> findByUid(int uid);



}
