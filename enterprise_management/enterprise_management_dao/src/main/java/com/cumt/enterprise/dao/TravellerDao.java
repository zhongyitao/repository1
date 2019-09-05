package com.cumt.enterprise.dao;

import com.cumt.enterprise.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TravellerDao {

    /**
     * 根据订单id查询游客信息
     * @param ordersId
     * @return
     */
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId);

}
