package com.cumt.enterprise.dao;

import com.cumt.enterprise.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    public List<Role> findByUserId(String userId);

}
