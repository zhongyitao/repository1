package com.cumt.springbootdemo1;

import com.cumt.springbootdemo1.dao.UserDao;
import com.cumt.springbootdemo1.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springbootdemo1Application.class)
public class Springbootdemo1ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void contextLoads() {
        List<User> userList = userDao.findAll();
        System.out.println(userList);
        System.out.println("jasdkflksdajkfals");
    }


    @Test
    public void rediesTest() throws JsonProcessingException {
        //从缓存中获取
        String userListData = redisTemplate.boundValueOps("user.findAll").get();
        if (null == userListData) {
            //如果缓存中没有，去数据库查
            System.out.println("========从数据库中获取============");
            List<User> users = userDao.findAll();
            //转换成json格式
            ObjectMapper objectMapper = new ObjectMapper();
            userListData = objectMapper.writeValueAsString(users);
            //保存到缓存中
            redisTemplate.boundValueOps("user.findAll").set(userListData);
        }
        else
        {

            System.out.println("========从缓存中获取============");
        }
        System.out.println(userListData);

    }

}
