package com.cumt.enterprise.controller;

import com.cumt.enterprise.domain.Product;
import com.cumt.enterprise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Product> productList = productService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        System.out.println(productList);
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduce(Product product){
        productService.save(product);
        return "redirect:/product/findAll.do";
    }
}
