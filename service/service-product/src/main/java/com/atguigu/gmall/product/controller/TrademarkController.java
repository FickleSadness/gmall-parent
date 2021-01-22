package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.TrademarkService;
import com.atguigu.gmall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xyh
 * @Date 2021/1/22 18:49
 * @Description
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class TrademarkController {

    @Autowired
    private TrademarkService trademarkService;

    @RequestMapping("baseTrademark/{page}/{limit}")
    public Result baseTrademark(@PathVariable("page") Long page,
                                @PathVariable("limit") Long limit) {

        IPage<BaseTrademark> iPage = trademarkService.baseTrademark(page, limit);
        return Result.ok(iPage);

    }

    @RequestMapping("baseTrademark/save")
    public Result save(@RequestBody BaseTrademark baseTrademark) {
        trademarkService.save(baseTrademark);
        return Result.ok();
    }

    @RequestMapping("baseTrademark/get/{trademarkId}")
    public Result get(@PathVariable("trademarkId") Long trademarkId) {
        BaseTrademark baseTrademark = trademarkService.get(trademarkId);
        return Result.ok(baseTrademark);
    }


    @PutMapping("baseTrademark/update")
    public Result update(@RequestBody BaseTrademark baseTrademark) {
        trademarkService.update(baseTrademark);
        return Result.ok();
    }


    @DeleteMapping("baseTrademark/remove/{trademarkId}")
    public Result remove(@PathVariable("trademarkId") Long trademarkId) {
        trademarkService.remove(trademarkId);
        return Result.ok();
    }

    @RequestMapping("baseTrademark/getTrademarkList")
    public Result getTrademarkList() {
        List<BaseTrademark> baseTrademarks = trademarkService.getTrademarkList();
        return Result.ok(baseTrademarks);
    }

}
