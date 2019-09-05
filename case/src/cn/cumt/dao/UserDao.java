package cn.cumt.dao;

import cn.cumt.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 按条件查询总记录数
     * @param condition
     * @return
     */
    int findTotalCountByCondition(Map<String, String[]> condition);


    /**
     * 条件查找
     * @param user
     * @return
     */
    List<User> findUserByFactor(User user);

    /**
     * 条件分页查询
     * @param start 开始值
     * @param rows 每页几行
     * @param parameterMap 条件
     * @return
     */
    List<User> findUserByPageAndFactor(int start, int rows, Map<String, String[]> parameterMap);



    /**
     * 删除用户信息
     * @param id 用户id
     * @return 成功返回true
     */
    boolean deleteUser(int id);

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回User对象
     */
    User findUserById(int id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    boolean addUser(User user);
}
