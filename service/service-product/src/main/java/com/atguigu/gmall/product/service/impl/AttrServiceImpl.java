package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.AttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xyh
 * @Date 2021/1/22 14:13
 * @Description
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseAttrInfo> attrInfoList(Long category3Id) {
        QueryWrapper<BaseAttrInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("category_level", 3);
        wrapper.eq("category_id", category3Id);
        List<BaseAttrInfo> baseAttrInfos = baseAttrInfoMapper.selectList(wrapper);

        if (baseAttrInfos != null && baseAttrInfos.size() > 0) {
            for (BaseAttrInfo baseAttrInfo : baseAttrInfos) {
                QueryWrapper<BaseAttrValue> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("attr_id", baseAttrInfo.getId());
                List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.selectList(wrapper1);
                baseAttrInfo.setAttrValueList(baseAttrValues);
            }
        }

        return baseAttrInfos;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {

        Long id = baseAttrInfo.getId();

        if (id != null && id != -1) {
            // 修改
            baseAttrInfoMapper.updateById(baseAttrInfo);
            // 删除+新增=修改
            QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
            wrapper.eq("attr_id", id);
            baseAttrValueMapper.delete(wrapper);
        } else {
            // 保存
            baseAttrInfoMapper.insert(baseAttrInfo);
            id = baseAttrInfo.getId();
        }

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        if (attrValueList != null && attrValueList.size() > 0) {
            for (BaseAttrValue baseAttrValue : attrValueList) {
                baseAttrValue.setAttrId(id);
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }

    }

    @Override
    public List<BaseAttrValue> getAttrValueList(Long attrId) {
        QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
        wrapper.eq("attr_id", attrId);
        return baseAttrValueMapper.selectList(wrapper);
    }
}
