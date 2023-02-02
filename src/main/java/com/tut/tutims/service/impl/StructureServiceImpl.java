package com.tut.tutims.service.impl;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.pojo.Article;
import com.tut.tutims.entry.pojo.Department;
import com.tut.tutims.entry.pojo.DepartmentType;
import com.tut.tutims.mapper.*;
import com.tut.tutims.service.StructureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StructureServiceImpl implements StructureService {
    @Resource
    ThreeAreaInfoMapper threeAreaInfoMapper;
    @Resource
    ArticleMapper articleMapper;
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    DepartmentTypeMapper departmentTypeMapper;
    @Resource
    GuardInfoMapper guardInfoMapper;
    @Resource
    ReportInfoMapper reportInfoMapper;

    /**
     * @param name 部门名称
     * @param type 部门类型名称
     * @description 根据部门类型新增一个部门，此部门类型若不存在则创建
     */
    @Override
    public synchronized CommonResult<String> addDepartment(String name, String type) {
        Department department = departmentMapper.selectByName(name);
        if (department != null) return CommonResult.fail("部门名称已存在");
        DepartmentType departmentType = departmentTypeMapper.selectByName(type);
        if (departmentType == null) {
            if (departmentTypeMapper.addByName(type) == 0) return CommonResult.fail("新增部门类型失败，请联系开发者");
            departmentType = departmentTypeMapper.selectByName(type);
        }
        Integer typeId = departmentType.getId();
        if (departmentMapper.addByNameAndType(name, typeId) == 0) return CommonResult.fail("新增部门失败，请联系开发者");
        return CommonResult.success("新增部门成功");
    }

    @Override
    public CommonResult<String> addArticle(Integer departmentId, String title, String author, Integer weekNum, String time) {
        if (articleMapper.addArticle(departmentId, title, author, weekNum, time) == 0)
            return CommonResult.fail("新增要讯失败，请联系开发者");
        Article article = articleMapper.selectNewOne();
        Integer articleId = article.getId();

        if (threeAreaInfoMapper.addOne(articleId) == 0) return CommonResult.fail("新增三区信息失败，请联系开发者");

        if (guardInfoMapper.addOne(articleId) == 0) return CommonResult.fail("新增警备区信息失败，请联系开发者");
        Integer id1 = guardInfoMapper.selectNewId();

        if (reportInfoMapper.addOne(articleId) == 0) return CommonResult.fail("新增摘报信息失败，请联系开发者");
        Integer id2 = reportInfoMapper.selectNewId();

        if (articleMapper.updateForeignId(id1, id2, articleId) == 0)
            return CommonResult.fail("关联警备区与摘报信息失败");

        return CommonResult.success("新增要讯成功");
    }
}
