package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.AttrService;
import com.atguigu.gmall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xyh
 * @Date 2021/1/22 14:08
 * @Description
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class AttrController {
    @Autowired
    private AttrService attrService;

    @RequestMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category1Id") Long category1Id,
                               @PathVariable("category2Id") Long category2Id,
                               @PathVariable("category3Id") Long category3Id) {
        List<BaseAttrInfo> baseAttrInfos = attrService.attrInfoList(category3Id);
        return Result.ok(baseAttrInfos);

    }

    @RequestMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        attrService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

    @RequestMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId") Long attrId) {
        List<BaseAttrValue> baseAttrValues = attrService.getAttrValueList(attrId);
        return Result.ok(baseAttrValues);
    }
}
