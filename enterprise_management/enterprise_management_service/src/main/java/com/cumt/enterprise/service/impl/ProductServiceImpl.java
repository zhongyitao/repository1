package com.cumt.enterprise.service.impl;

import com.cumt.enterprise.domain.Product;
import com.cumt.enterprise.dao.ProductDao;
import com.cumt.enterprise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 查询所有产品
     *
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * 保存产品信息
     *
     * @param product
     * @return
     */
    @Override
    @Transactional
    public boolean save(Product product) {
        return productDao.saveProduct(product);

    }
}
