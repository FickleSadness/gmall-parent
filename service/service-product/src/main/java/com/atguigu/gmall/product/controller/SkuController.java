package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.product.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xyh
 * @Date 2021/1/22 21:04
 * @Description
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;


}
