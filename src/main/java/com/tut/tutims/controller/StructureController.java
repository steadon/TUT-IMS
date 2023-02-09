package com.tut.tutims.controller;

import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.dto.param.AddArticleParam;
import com.tut.tutims.pojo.dto.param.AddDepartmentParam;
import com.tut.tutims.service.StructureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@CrossOrigin
@RestController
public class StructureController {

    private final StructureService structureService;

    @Autowired
    public StructureController(StructureService structureService) {
        this.structureService = structureService;
    }

    @PostMapping("/add/article")
    public CommonResult<String> addArticle(@RequestBody @Validated AddArticleParam param, HttpServletRequest request) {
        var departmentId = param.getDepartmentId();
        var title = param.getTitle();
        var author = param.getAuthor();
        var time = param.getTime();
        log.info(request.getRequestURI());
        return structureService.addArticle(departmentId, title, author, time);
    }

    @PostMapping("/add/department")
    public CommonResult<String> addDepartment(@RequestBody @Validated AddDepartmentParam param, HttpServletRequest request) {
        var type = param.getType();
        var name = param.getName();
        log.info(request.getRequestURI());
        return structureService.addDepartment(name, type);
    }
}
