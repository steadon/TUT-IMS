package com.tut.tutims.controller;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.param.*;
import com.tut.tutims.entry.result.AllDataList;
import com.tut.tutims.entry.result.DepartmentList;
import com.tut.tutims.entry.result.TotalDataList;
import com.tut.tutims.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService service) {
        this.dataService = service;
    }

    @GetMapping("/get/department")
    public CommonResult<DepartmentList> getDepartment() {
        return dataService.getAllDepartment();
    }

    @PostMapping("/update/guard")
    public CommonResult<String> updateGuardInfo(@RequestBody GuardInfoParam param) {
        return dataService.updateGuardInfo(param);
    }

    @PostMapping("/update/report")
    public CommonResult<String> updateReportInfo(@RequestBody ReportInfoParam param) {
        return dataService.updateReportInfo(param);
    }

    @PostMapping("/update/area")
    public CommonResult<String> updateAreaInfo(@RequestBody AreaInfoParam param) {
        return dataService.updateAreaInfo(param);
    }

    @GetMapping("/get/scoreList")
    public CommonResult<TotalDataList> getScoreList() {
        return dataService.getScoreList();
    }

    @GetMapping("/get/allData")
    public CommonResult<AllDataList> getAll() {
        return dataService.getAll();
    }

    @PostMapping("/update/agreeInfo")
    CommonResult<String> updateAgreeInfo(@RequestBody InfoScoreParam param) {
        return dataService.updateAgreeInfo(param);
    }

    @PostMapping("/update/loseInfo")
    CommonResult<String> updateLoseInfo(@RequestBody InfoScoreParam param) {
        return dataService.updateLoseInfo(param);
    }

    @PostMapping("/update/addInfo")
    CommonResult<String> updateAddInfo(@RequestBody StringParam param) {
        return dataService.updateAddInfo(param);
    }
}
