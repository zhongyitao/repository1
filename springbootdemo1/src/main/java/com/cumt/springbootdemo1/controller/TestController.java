package com.cumt.springbootdemo1.controller;

import com.cumt.springbootdemo1.dao.UserDao;
import com.cumt.springbootdemo1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping("/hello")
    public List<User> Test(){
        List<User> userList = userDao.findAll();
        return userList;
    }
}
