package com.cumt.enterprise.domain;

import com.cumt.enterprise.utils.TypeConversionUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Product {

    private String id;//主键
    private String productNum;//唯一编号
    private String productName;//名称
    private String cityName;//出发城市
    private Date departureTime;//出发时间
    private String departureTimeStr;
    private double productPrice;//产品价格
    private String productDesc;//产品描述
    private Integer productStatus;//状态 0关闭 1开启
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    //获得时间字符串
    public String getDepartureTimeStr() {
        return TypeConversionUtils.dateToString(departureTime,"yyyy-MM-dd HH-mm-ss");
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    //获得状态字符串
    public String getProductStatusStr() {
        if (null != productStatus){
            if (productStatus == 0){
                productStatusStr = "关闭";
            }
            if (productStatus == 1){
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}