package com.tut.tutims.service.impl;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.pojo.AreaView;
import com.tut.tutims.entry.result.AreaViewList;
import com.tut.tutims.mapper.AreaViewMapper;
import com.tut.tutims.service.ResultService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    AreaViewMapper areaViewMapper;

    @Override
    @Cacheable(cacheNames = "areaView")
    public CommonResult<AreaViewList> consumeInfo(Integer areaId) {
        List<AreaView> areaViews = areaViewMapper.selectAllById(areaId);
        //移除空数据
        areaViews.removeIf(areaView -> areaView.getAreaId() != 3 && areaView.getTitle() == null);
        //空链响应
        if (areaViews.isEmpty()) return CommonResult.fail("暂无数据");
        //添加索引
        for (int i = 0, j = 1; i < areaViews.size(); i++, j++) {
            AreaView areaView = areaViews.get(i);
            areaView.setId(j);
        }
        AreaViewList areaViewList = new AreaViewList(areaViews);
        return CommonResult.success(areaViewList);
    }
}
