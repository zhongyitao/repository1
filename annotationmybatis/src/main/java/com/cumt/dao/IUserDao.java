package com.cumt.dao;

import com.cumt.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.cumt.dao.IAccountDao.findByUid",
                            fetchType = FetchType.LAZY) )
    })
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(int id);

    /**
     * 根据条件模糊查询
     * @param user
     * @return
     */
    @Select("<script>select * from user\n" +
            "\t\t<where>\n" +
            "            <if test=\"username != null\">\n" +
            "                 and username like #{username} \n" +
            "            </if>\n" +
            "            <if test=\"null != sex\">\n" +
            "                 and sex like #{sex} \n" +
            "            </if>\n" +
            "            <if test=\"null != address\">\n" +
            "                 and address like #{address} \n" +
            "            </if>\n" +
            "            <if test=\"null != birthday\">\n" +
            "                 and birthday like #{birthday} \n" +
            "            </if>\n" +
            "        </where>\n" +
            "</script>")
    List<User> findByCondition(User user);

    /**
     * insert用户信息
     * @param user
     */
    @Insert("insert into user (username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 更新数据
     * @param user
     */
    @Update("update user set username = #{username},birthday = #{birthday},sex = #{sex},address = #{address} where id = #{id}")
    void updateUser(User user);

    /**
     * 根据Id删除数据
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
}
