package com.cumt.enterprise.service;

import com.cumt.enterprise.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有产品
     * @return
     */
    public List<Product> findAll();

    /**
     * 保存产品信息
     * @param product
     * @return
     */
    public boolean save(Product product);

}
