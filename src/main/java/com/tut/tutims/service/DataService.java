package com.tut.tutims.service;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.param.AreaInfoParam;
import com.tut.tutims.entry.param.GuardInfoParam;
import com.tut.tutims.entry.param.ReportInfoParam;
import com.tut.tutims.entry.result.DepartmentList;
import com.tut.tutims.entry.result.TotalDataList;

public interface DataService {
    CommonResult<DepartmentList> getAllDepartment();

    CommonResult<String> updateGuardInfo(GuardInfoParam param);

    CommonResult<String> updateReportInfo(ReportInfoParam param);

    CommonResult<String> updateAreaInfo(AreaInfoParam param);

    CommonResult<TotalDataList> getScoreList();
}
