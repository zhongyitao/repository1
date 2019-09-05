package cn.cumt.service.impl;

import cn.cumt.dao.UserDao;
import cn.cumt.dao.impl.UserDaoImpl;
import cn.cumt.domain.PageBean;
import cn.cumt.domain.User;
import cn.cumt.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        //调用dao中的findAll()方法在数据库中查询
        List<User> users = userDao.findAll();
        return users;
    }

    /**
     * 条件分页查询
     *
     * @param currentPage  当前页
     * @param rows         每页条数
     * @param parameterMap 查询条件
     * @return 返回结果集
     */
    @Override
    public PageBean<User> findUserByFactor(String currentPage, String rows, Map<String, String[]> parameterMap) {

        int currentPageInt = Integer.parseInt(currentPage);
        int rowsInt = Integer.parseInt(rows);
        int start = (currentPageInt - 1) * rowsInt;

        int totalCount = userDao.findTotalCountByCondition(parameterMap);
        List<User> users = userDao.findUserByPageAndFactor(start,rowsInt,parameterMap);


        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrentPage(currentPageInt);
        pageBean.setRows(rowsInt);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalCount % rowsInt == 0 ? totalCount/rowsInt : totalCount/rowsInt + 1);
        pageBean.setUserList(users);

        return pageBean;
    }


    /**
     * 根据id删除用户信息
     *
     * @param id 用户ID
     * @return 删除成功返回true否则返回false
     */
    @Override
    public boolean deleteUser(int id) {

        //调用dao操作数据库
        return userDao.deleteUser(id);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 返回查询结果User对象
     */
    @Override
    public User findUserById(int id) {

        return userDao.findUserById(id);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {

        return userDao.addUser(user);
    }

    /**
     * 删除选中
     *
     * @param userIds
     * @return
     */
    @Override
    public boolean deleteSelectedUser(String[] userIds) {

        boolean flag = false;
        if (null != userIds && userIds.length > 0)
        {
            for (String id : userIds)
            {

                flag = userDao.deleteUser(Integer.parseInt(id));
                if (!flag)
                {
                    return flag;
                }
            }
        }
        return flag;
    }


}
