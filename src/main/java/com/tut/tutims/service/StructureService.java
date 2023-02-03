package com.tut.tutims.service;

import com.tut.tutims.pojo.CommonResult;

public interface StructureService {
    CommonResult<String> addDepartment(String name, String type);

    CommonResult<String> addArticle(Integer departmentId, String title, String author, Integer weekNum, String time);
}
