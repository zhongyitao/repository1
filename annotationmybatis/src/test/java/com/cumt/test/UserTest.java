package com.cumt.test;

import com.cumt.dao.IUserDao;
import com.cumt.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {

    private IUserDao userDaoProxy;
    private SqlSession sqlSession;
    private InputStream in;


    @Before
    public void init() throws Exception
    {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactor构建者
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        //创建sqlsessionfactory工厂
        SqlSessionFactory factory = builder.build(in);
        //由工厂生产sqlsession
        sqlSession = factory.openSession();
        //由sqlsession创建代理对象
        userDaoProxy = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception
    {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }


    /**
     * 测试查询所有
     *
     */
    @Test
    public void findAllTest (){

        //由代理对象调用方法
        List<User> users = userDaoProxy.findAll();
        //System.out.println(users.get(1));
        //System.out.println(users);
        /*for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }*/
    }

    /**
     * 测试根据ID查询数据
     */
    @Test
    public void findByIdTest()
    {
        User user = userDaoProxy.findById(41);
        System.out.println(user);

        User user1 = userDaoProxy.findById(41);
        System.out.println(user1);

    }

    /**
     * 测试根据条件查询数据
     */
    @Test
    public void findByConditionTest()
    {
        User user = new User();
        user.setUsername("%王%");
        List<User> users = userDaoProxy.findByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 测试保存用户数据
     */
    @Test
    public void saveUserTest()
    {
        User user = new User();
        user.setUsername("张翠山");
        user.setAddress("南京");
        user.setBirthday("2019-8-8");
        user.setSex("男");
        System.out.println(user);
        userDaoProxy.saveUser(user);
        System.out.println(user);

    }

    /**
     * 测试更新用户数据
     */
    @Test
    public void updateUserTest()
    {
        User user = new User();
        user.setId(56);
        user.setUsername("张三丰");
        user.setAddress("西藏");
        user.setBirthday("2016-8-8");
        user.setSex("男");
        System.out.println(user);
        userDaoProxy.updateUser(user);
        System.out.println(user);

    }

    /**
     * 测试删除用户数据
     */
    @Test
    public void deleteUserTest()
    {
        userDaoProxy.deleteUser(57);

    }

}
