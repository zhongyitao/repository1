package com.cumt.enterprise.dao;

import com.cumt.enterprise.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll();

    /**
     * 保存
     * @param product
     * @return
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public boolean saveProduct(Product product);

    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    public Product findById(String id);

}
