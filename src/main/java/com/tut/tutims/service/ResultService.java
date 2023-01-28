package com.tut.tutims.service;


import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.result.AreaViewList;

public interface ResultService {
    CommonResult<AreaViewList> consumeInfo(Integer areaId);

}
