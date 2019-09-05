package com.cumt.enterprise.service.impl;

import com.cumt.enterprise.dao.OrdersDao;
import com.cumt.enterprise.domain.Orders;
import com.cumt.enterprise.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 查询所有订单
     *
     * @return
     */
    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    /**
     * 查询所有订单（分页）
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Orders> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ordersDao.findAll();
    }

    /**
     * 根据id查询
     *
     * @param ordersId
     * @return
     */
    @Override
    public Orders findAllById(String ordersId) {
        return ordersDao.findById(ordersId);
    }
}
