package com.tut.tutims.controller;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.result.AreaViewList;
import com.tut.tutims.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("get/area")
    public CommonResult<AreaViewList> consumeInfo(Integer areaId) {
        return resultService.consumeInfo(areaId);
    }
}
