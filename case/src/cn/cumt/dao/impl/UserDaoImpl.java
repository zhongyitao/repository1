package cn.cumt.dao.impl;

import cn.cumt.dao.UserDao;
import cn.cumt.domain.User;
import cn.cumt.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao{

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 条件分页查询
     *
     * @param start        开始值
     * @param rows         每页几行
     * @param parameterMap 条件
     * @return
     */
    @Override
    public List<User> findUserByPageAndFactor(int start, int rows, Map<String, String[]> parameterMap) {

        StringBuilder sql = new StringBuilder("select * from user where 1=1 ");

        Set<String> keys = parameterMap.keySet();
        List<Object> params = new ArrayList<>();

        for (String key : keys)
        {
            if ("currentPage".equals(key) || "rows".equals(key))
            {
                continue;
            }

            String value = parameterMap.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sql.append(" and "+ key +" like ?");
                params.add("%" + value + "%");//？条件的值
            }
        }

        sql.append(" limit ?,?");
        params.add(start);
        params.add(rows);
        System.out.println(sql.toString());
        System.out.println(params);

        List<User> userList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<User>(User.class),params.toArray());



        return userList;
    }




    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAll() {

        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return userList;
    }

    /**
     * 按条件查询总记录数
     *
     * @param condition
     * @return
     */
    @Override
    public int findTotalCountByCondition(Map<String, String[]> condition) {

        StringBuilder sql = new StringBuilder("select count(*) from user where 1=1 ");

        Set<String> keys = condition.keySet();
        List<Object> params = new ArrayList<>();

        for (String key : keys)
        {
            if ("currentPage".equals(key) || "rows".equals(key))
            {
                continue;
            }
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sql.append(" and "+key+" like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }

        int totalCount = jdbcTemplate.queryForObject(sql.toString(), Integer.class, params.toArray());


        return totalCount;
    }

    /**
     * 条件查找
     *
     * @param user
     * @return
     */
    @Override
    public List<User> findUserByFactor(User user) {
        return null;
    }


    /**
     * 删除用户信息
     *
     * @param id 用户id
     * @return 成功返回true
     */
    @Override
    public boolean deleteUser(int id) {
        String sql = "delete from user where id=?";
        int i = 0;
        try {
            i = jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return i > 0;
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 返回User对象
     */
    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id=?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        int i = 0;
        try {
            i = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(),
                    user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }


        return i > 0;
    }

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        String sql = "insert into user (name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
        int i = 0;
        try {
            i = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(),
                    user.getAddress(), user.getQq(), user.getEmail());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }


        return i > 0;
    }
}
