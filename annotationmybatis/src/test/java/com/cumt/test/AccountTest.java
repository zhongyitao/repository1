package com.cumt.test;

import com.cumt.dao.IAccountDao;
import com.cumt.domain.Account;
import com.cumt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private IAccountDao accountDaoProxy;
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
        accountDaoProxy = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> accounts = accountDaoProxy.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 测试根据id查询
     *
     */
    @Test
    public void findByIdTest (){

        //由代理对象调用方法
        Account account = accountDaoProxy.findById(1);

        System.out.println(account);

    }

    /**
     * 测试根据uid查询
     *
     */
    @Test
    public void findByUidTest (){

        //由代理对象调用方法
        List<Account> accounts = accountDaoProxy.findByUid(41);

        for (Account account : accounts) {
            System.out.println(account);
        }
    }




}
