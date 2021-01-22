package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.mapper.BaseTrademarkMapper;
import com.atguigu.gmall.product.service.TrademarkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xyh
 * @Date 2021/1/22 18:51
 * @Description
 */
@Service
public class TrademarkServiceImpl implements TrademarkService {
    @Autowired
    private BaseTrademarkMapper baseTrademarkMapper;

    @Override
    public IPage<BaseTrademark> baseTrademark(Long page, Long limit) {
        Page<BaseTrademark> trademarkPage = new Page<>(page, limit);

        return baseTrademarkMapper.selectPage(trademarkPage, null);
    }

    @Override
    public void save(BaseTrademark baseTrademark) {
        if (baseTrademark != null) {
            baseTrademarkMapper.insert(baseTrademark);
        }
    }

    @Override
    public BaseTrademark get(Long trademarkId) {
        return baseTrademarkMapper.selectById(trademarkId);
    }

    @Override
    public void update(BaseTrademark baseTrademark) {
        if (baseTrademark != null) {
            baseTrademarkMapper.updateById(baseTrademark);
        }

    }

    @Override
    public void remove(Long trademarkId) {
        baseTrademarkMapper.deleteById(trademarkId);
    }

    @Override
    public List<BaseTrademark> getTrademarkList() {
        return baseTrademarkMapper.selectList(null);
    }
}
