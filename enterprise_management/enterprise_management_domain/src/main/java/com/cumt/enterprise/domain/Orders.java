package com.cumt.enterprise.domain;

import com.cumt.enterprise.utils.TypeConversionUtils;

import java.util.Date;
import java.util.List;

public class Orders {

    private String id;//主键uuid
    private String orderNum;//订单编号 不为空 唯一
    private Date orderTime;//下单时间
    private String orderTimeStr;
    private Integer peopleCount;//出行人数
    private String orderDesc;//订单描述(其它信息)
    private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private Integer orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private Product product;//产品
    private Member member;//会员(联系人）
    private List<Traveller> travellers;//游客列表

    public String getOrderTimeStr() {
        return TypeConversionUtils.dateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
    }

    public String getPayTypeStr() {
        if (null != payType){
            switch (payType){
                case 0:
                    payTypeStr = "支付宝";
                    break;
                case 1:
                    payTypeStr = "微信";
                    break;
                case 2:
                    payTypeStr = "其他";
                    break;
            }
        }
        return payTypeStr;
    }

    public String getOrderStatusStr() {
        if (null != orderStatus){
            if (orderStatus == 0){
                orderStatusStr = "未支付";
            }
            if (orderStatus == 1){
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
