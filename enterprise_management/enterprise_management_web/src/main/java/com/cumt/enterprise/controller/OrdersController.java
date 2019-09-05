package com.cumt.enterprise.controller;

import com.cumt.enterprise.domain.Orders;
import com.cumt.enterprise.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findAllPaging.do")
    public ModelAndView findAllPaging(@RequestParam(name = "pageNum", required = true, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize){
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("ordersPageList",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId){
        Orders orders = ordersService.findAllById(ordersId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("orders-details");
        return mv;
    }

}
