package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.CategoryService;
import com.atguigu.gmall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xyh
 * @Date 2021/1/20 18:54
 * @Description
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("getCategory1")
    public Result getCategory1() {
        List<BaseCategory1> baseCategory1s = categoryService.getCategory1();
        return Result.ok(baseCategory1s);
    }

    @RequestMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable Long category1Id) {
        List<BaseCategory2> baseCategory2s = categoryService.getCategory2(category1Id);
        return Result.ok(baseCategory2s);
    }

    @RequestMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable Long category2Id) {
        List<BaseCategory3> baseCategory3s = categoryService.getCategory3(category2Id);
        return Result.ok(baseCategory3s);
    }

}
