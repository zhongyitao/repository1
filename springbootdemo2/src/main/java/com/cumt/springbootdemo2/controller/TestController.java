package com.cumt.springbootdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String Test(){
        return "Hello!!!wqeqewqrw";
    }

}
