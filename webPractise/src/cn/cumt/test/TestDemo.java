package cn.cumt.test;

import cn.cumt.dao.UserDao;
import cn.cumt.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class TestDemo {

    @Test
    public void loginTest()
    {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("yiweuow");
        System.out.println(user);
        UserDao  dao = new UserDao();
        User user1 = dao.login(user);
        System.out.println(user1);

    }

    /*@Test
    public void beanUtilsTest()
    {
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }*/


}
