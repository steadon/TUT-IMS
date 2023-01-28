package com.tut.tutims.controller;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.param.AreaInfoParam;
import com.tut.tutims.entry.param.GuardInfoParam;
import com.tut.tutims.entry.param.ReportInfoParam;
import com.tut.tutims.entry.result.DepartmentList;
import com.tut.tutims.entry.result.TotalDataList;
import com.tut.tutims.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
