package com.cumt.service;

import com.cumt.domain.ResultInfo;
import com.cumt.domain.User;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return 返回注册结果
     */
    ResultInfo register(User user);

    boolean active(String code);

    User login(User user);

}
