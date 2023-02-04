package com.tut.tutims.controller;

import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.dto.result.AreaViewList;
import com.tut.tutims.pojo.dto.result.TotalDataList;
import com.tut.tutims.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@CrossOrigin
@RestController
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("get/area")
    public CommonResult<AreaViewList> consumeInfo(@RequestParam Integer areaId, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return resultService.consumeInfo(areaId);
    }

    @GetMapping("/get/scoreList")
    public CommonResult<TotalDataList> getScoreList(HttpServletRequest request) {
        log.info(request.getRequestURI());
        return resultService.getScoreList();
    }
}
