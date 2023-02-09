package com.tut.tutims.service.impl;

import com.tut.tutims.mapper.*;
import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.domain.Article;
import com.tut.tutims.pojo.domain.Department;
import com.tut.tutims.pojo.domain.DepartmentType;
import com.tut.tutims.service.StructureService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.tut.tutims.common.Common.OriginKey;

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

    @Override
    @CacheEvict(cacheNames = {"departmentList", "allData"}, key = OriginKey)
    public synchronized CommonResult<String> addDepartment(String name, String type) {
        Department department = departmentMapper.selectByName(name);
        if (department != null) return CommonResult.fail("部门名称已存在");
        DepartmentType departmentType = departmentTypeMapper.selectByName(type);
        if (departmentType == null) {
            if (departmentTypeMapper.addByName(type) == 0) return CommonResult.fail("新增部门类型失败，请联系开发者");
            departmentType = departmentTypeMapper.selectByName(type);
        }
        var typeId = departmentType.getId();
        if (departmentMapper.addByNameAndType(name, typeId) == 0) return CommonResult.fail("新增部门失败，请联系开发者");
        return CommonResult.success("新增部门成功");
    }

    @Override
    @CacheEvict(cacheNames = {"allData", "scoreList", "areaView"}, key = OriginKey)
    public CommonResult<String> addArticle(Integer departmentId, String title, String author, String time) {
        if (articleMapper.addArticle(departmentId, title, author, time) == 0)
            return CommonResult.fail("新增要讯失败，请联系开发者");
        Article article = articleMapper.selectNewOne();
        var articleId = article.getId();

        if (threeAreaInfoMapper.addOne(articleId) == 0) return CommonResult.fail("新增三区信息失败，请联系开发者");

        if (guardInfoMapper.addOne(articleId) == 0) return CommonResult.fail("新增警备区信息失败，请联系开发者");
        var id1 = guardInfoMapper.selectNewId();

        if (reportInfoMapper.addOne(articleId) == 0) return CommonResult.fail("新增摘报信息失败，请联系开发者");
        var id2 = reportInfoMapper.selectNewId();

        if (articleMapper.updateForeignId(id1, id2, articleId) == 0)
            return CommonResult.fail("关联警备区与摘报信息失败");

        return CommonResult.success("新增要讯成功");
    }
}
