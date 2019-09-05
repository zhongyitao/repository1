package com.cumt.enterprise.service;

import com.cumt.enterprise.domain.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * 查询所有订单
     * @return
     */
    public List<Orders> findAll();

    /**
     * 查询所有订单（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Orders> findAll(int pageNum, int pageSize);

    /**
     * 根据id查询
     * @param ordersId
     * @return
     */
    public Orders findAllById(String ordersId);
}
