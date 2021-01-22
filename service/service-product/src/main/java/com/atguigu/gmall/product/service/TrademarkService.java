package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Author xyh
 * @Date 2021/1/22 18:51
 * @Description
 */
public interface TrademarkService {
    IPage<BaseTrademark> baseTrademark(Long page, Long limit);

    void save(BaseTrademark baseTrademark);

    BaseTrademark get(Long trademarkId);

    void update(BaseTrademark baseTrademark);

    void remove(Long trademarkId);

    List<BaseTrademark> getTrademarkList();
}
