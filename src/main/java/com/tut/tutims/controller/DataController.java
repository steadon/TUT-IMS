package com.tut.tutims.controller;

import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.dto.param.*;
import com.tut.tutims.pojo.dto.result.AllDataList;
import com.tut.tutims.pojo.dto.result.DepartmentList;
import com.tut.tutims.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.tut.tutims.common.Common.OriginKey;

@Slf4j
@CrossOrigin
@RestController
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService service) {
        this.dataService = service;
    }

    @GetMapping("/get/allData")
    public CommonResult<AllDataList> getAll(@RequestParam(required = false, defaultValue = OriginKey) String name, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.getAll(name);
    }

    @GetMapping("/get/department")
    public CommonResult<DepartmentList> getDepartment(HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.getAllDepartment();
    }

    @PostMapping("/update/guard")
    public CommonResult<String> updateGuardInfo(@RequestBody GuardInfoParam param, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.updateGuardInfo(param);
    }

    @PostMapping("/update/report")
    public CommonResult<String> updateReportInfo(@RequestBody ReportInfoParam param, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.updateReportInfo(param);
    }

    @PostMapping("/update/area")
    public CommonResult<String> updateAreaInfo(@RequestBody AreaInfoParam param, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.updateAreaInfo(param);
    }

    @PostMapping("/update/agreeInfo")
    CommonResult<String> updateAgreeInfo(@RequestBody InfoScoreParam param, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.updateAgreeInfo(param);
    }

    @PostMapping("/update/loseInfo")
    CommonResult<String> updateLoseInfo(@RequestBody InfoScoreParam param, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.updateLoseInfo(param);
    }

    @PostMapping("/update/addInfo")
    CommonResult<String> updateAddInfo(@RequestBody StringParam param, HttpServletRequest request) {
        log.info(request.getRequestURI());
        return dataService.updateAddInfo(param);
    }
}
