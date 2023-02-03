package com.tut.tutims.service;


import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.dto.result.AreaViewList;
import com.tut.tutims.pojo.dto.result.TotalDataList;

public interface ResultService {
    CommonResult<AreaViewList> consumeInfo(Integer areaId);

    CommonResult<TotalDataList> getScoreList();

}
