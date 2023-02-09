package com.tut.tutims.service;

import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.dto.param.*;
import com.tut.tutims.pojo.dto.result.AllDataList;
import com.tut.tutims.pojo.dto.result.DepartmentList;

public interface DataService {
    CommonResult<DepartmentList> getAllDepartment();

    CommonResult<AllDataList> getAll(String name);

    CommonResult<String> updateGuardInfo(GuardInfoParam param);

    CommonResult<String> updateReportInfo(ReportInfoParam param);

    CommonResult<String> updateAreaInfo(AreaInfoParam param);

    CommonResult<String> updateAgreeInfo(InfoScoreParam param);

    CommonResult<String> updateLoseInfo(InfoScoreParam param);

    CommonResult<String> updateAddInfo(StringParam param);
}
