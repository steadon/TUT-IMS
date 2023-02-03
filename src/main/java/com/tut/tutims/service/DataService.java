package com.tut.tutims.service;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.param.*;
import com.tut.tutims.entry.result.AllDataList;
import com.tut.tutims.entry.result.DepartmentList;
import com.tut.tutims.entry.result.TotalDataList;

public interface DataService {
    CommonResult<AllDataList> getAll();

    CommonResult<DepartmentList> getAllDepartment();

    CommonResult<String> updateGuardInfo(GuardInfoParam param);

    CommonResult<String> updateReportInfo(ReportInfoParam param);

    CommonResult<String> updateAreaInfo(AreaInfoParam param);

    CommonResult<TotalDataList> getScoreList();

    CommonResult<String> updateAgreeInfo(InfoScoreParam param);

    CommonResult<String> updateLoseInfo(InfoScoreParam param);

    CommonResult<String> updateAddInfo(StringParam param);
}
