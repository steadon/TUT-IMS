package com.tut.tutims.controller;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.param.AddArticleParam;
import com.tut.tutims.entry.param.AddDepartmentParam;
import com.tut.tutims.service.StructureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CommonResult<String> addArticle(@RequestBody AddArticleParam param, HttpServletRequest request) {
        Integer departmentId = param.getDepartmentId();
        String title = param.getTitle();
        String author = param.getAuthor();
        Integer weekNum = param.getWeekNum();
        String time = param.getTime();
        log.info(request.getRequestURI());
        return structureService.addArticle(departmentId, title, author, weekNum, time);
    }

    @PostMapping("/add/department")
    public CommonResult<String> addDepartment(@RequestBody AddDepartmentParam param) {
        String type = param.getType();
        String name = param.getName();
        return structureService.addDepartment(name, type);
    }

}
