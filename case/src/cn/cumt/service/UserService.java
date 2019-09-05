package cn.cumt.service;

import cn.cumt.domain.PageBean;
import cn.cumt.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 查询所有用户信息
     * @return 返回所有用户信息
     */
    List<User> findAll();

    /**
     * 条件分页查询
     * @param currentPage 当前页
     * @param rows 每页条数
     * @param parameterMap 查询条件
     * @return 返回结果集
     */
    PageBean<User> findUserByFactor(String currentPage, String rows, Map<String,String[]> parameterMap);

    /**
     * 根据id删除用户信息
     * @param id 用户ID
     * @return 删除成功返回true否则返回false
     */
    boolean deleteUser(int id);

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回查询结果User对象
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

    /**
     * 删除选中
     * @param userIds
     * @return
     */
    boolean deleteSelectedUser(String[] userIds);


}
