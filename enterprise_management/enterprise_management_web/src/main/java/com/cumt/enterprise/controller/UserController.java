package com.cumt.enterprise.controller;

import com.cumt.enterprise.dao.UserDao;
import com.cumt.enterprise.domain.UserInfo;
import com.cumt.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll();
        mv.addObject("userInfos",userInfos);
        mv.setViewName("user-list");
        return mv;
    }

}
