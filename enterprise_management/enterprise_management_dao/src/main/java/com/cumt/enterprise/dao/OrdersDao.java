package com.cumt.enterprise.dao;

import com.cumt.enterprise.domain.Orders;
import com.cumt.enterprise.domain.Product;
import com.cumt.enterprise.domain.Member;
import com.cumt.enterprise.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    /**
     * 查询所有订单
     * @return
     * private String id;//主键uuid
     *     private String orderNum;//订单编号 不为空 唯一
     *     private Date orderTime;//下单时间
     *     private String orderTimeStr;
     *     private Integer peopleCount;//出行人数
     *     private String orderDesc;//订单描述(其它信息)
     *     private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
     *     private String payTypeStr;
     *     private Integer orderStatus;//订单状态(0 未支付 1 已支付)
     *     private String orderStatusStr;
     *     private Product product;//产品
     *     private Member member;//会员(联系人）
     */
    @Select("select * from orders")
    @Results({@Result(id = true, property = "id", column = "ID"),
            @Result(property = "orderNum", column = "ORDERNUM"),
            @Result(property = "orderTime", column = "ORDERTIME"),
            @Result(property = "peopleCount", column = "PEOPLECOUNT"),
            @Result(property = "orderDesc", column = "ORDERDESC"),
            @Result(property = "payType", column = "PAYTYPE"),
            @Result(property = "orderStatus", column = "ORDERSTATUS"),
            @Result(property = "product", column = "PRODUCTID", javaType = Product.class, one = @One(select = "com.cumt.enterprise.dao.ProductDao.findById")),
            @Result(property = "member", column = "MEMBERID", javaType = Member.class, one = @One(select = "com.cumt.enterprise.dao.MemberDao.findById")),
    })
    public List<Orders> findAll();

    /**
     * 根据id查询
     * @param ordersId
     * @return
     */
    @Select("select * from orders where id = #{ordersId}")
    @Results({@Result(id = true, property = "id", column = "ID"),
            @Result(property = "orderNum", column = "ORDERNUM"),
            @Result(property = "orderTime", column = "ORDERTIME"),
            @Result(property = "peopleCount", column = "PEOPLECOUNT"),
            @Result(property = "orderDesc", column = "ORDERDESC"),
            @Result(property = "payType", column = "PAYTYPE"),
            @Result(property = "orderStatus", column = "ORDERSTATUS"),
            @Result(property = "product", column = "PRODUCTID", javaType = Product.class, one = @One(select = "com.cumt.enterprise.dao.ProductDao.findById")),
            @Result(property = "member", column = "MEMBERID", javaType = Member.class, one = @One(select = "com.cumt.enterprise.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "ID", javaType = List.class, many = @Many(select = "com.cumt.enterprise.dao.TravellerDao.findByOrdersId"))
    })
    public Orders findById(String ordersId);
}
