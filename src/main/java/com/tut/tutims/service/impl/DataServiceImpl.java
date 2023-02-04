package com.tut.tutims.service.impl;

import com.tut.tutims.mapper.*;
import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.domain.Department;
import com.tut.tutims.pojo.domain.TotalView;
import com.tut.tutims.pojo.domain.TotalViewParam;
import com.tut.tutims.pojo.dto.param.*;
import com.tut.tutims.pojo.dto.result.AllDataList;
import com.tut.tutims.pojo.dto.result.DepartmentList;
import com.tut.tutims.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DataServiceImpl implements DataService {
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    ArticleMapper articleMapper;
    @Resource
    TotalViewMapper totalViewMapper;
    @Resource
    ThreeAreaInfoMapper threeAreaInfoMapper;
    @Resource
    GuardInfoMapper guardInfoMapper;
    @Resource
    ReportInfoMapper reportInfoMapper;

    @Override
//    @Cacheable(cacheNames = "departmentList")
    public CommonResult<DepartmentList> getAllDepartment() {
        List<Department> departments = departmentMapper.selectAllDepartment();
        if (departments == null) return CommonResult.fail("暂未创建任何部门");
        DepartmentList list = new DepartmentList(departments);
        return CommonResult.success(list);
    }

    @Override
//    @Cacheable(cacheNames = "allData")
    public CommonResult<AllDataList> getAll() {
        List<TotalView> totalViews = totalViewMapper.selectAll();
        if (totalViews.isEmpty()) return CommonResult.fail("暂无数据");
        //按前端要求包装
        List<TotalViewParam> paramList = new ArrayList<>();
        for (TotalView totalView : totalViews) {
            TotalViewParam param = new TotalViewParam(totalView);
            paramList.add(param);
        }
        AllDataList list = new AllDataList(paramList);
        return CommonResult.success(list);
    }

    @Override
//    @CacheEvict(cacheNames = {"allData", "scoreList"})
    public CommonResult<String> updateGuardInfo(GuardInfoParam param) {
        Integer articleId = param.getArticleId();
        Double score = param.getScore();
        boolean isPublic = param.getIsPublic().equals("是");
        String issueNum = param.getIssueNum();
        String mainForm = param.getMainForm();
        String publicForm = param.getPublicForm();
        if (guardInfoMapper.updateInfo(isPublic, publicForm, mainForm, issueNum, score, articleId) == 0)
            return CommonResult.fail("更新警备区信息失败");
        return CommonResult.success("更新成功");
    }

    @Override
//    @CacheEvict(cacheNames = {"allData", "scoreList"})
    public CommonResult<String> updateReportInfo(ReportInfoParam param) {
        Integer articleId = param.getArticleId();
        String signDate = param.getSignDate();
        String askNum = param.getAskNum();
        String isAgree = param.getIsAgree();
        String pushNum = param.getPushNum();
        String pushTitle = param.getPushTitle();
        if (reportInfoMapper.updateInfo(pushNum, askNum, pushTitle, isAgree, signDate, articleId) == 0)
            return CommonResult.fail("更新上报信息失败");
        return CommonResult.success("更新成功");
    }

    @Override
//    @CacheEvict(cacheNames = {"allData", "scoreList", "areaView"})
    public CommonResult<String> updateAreaInfo(AreaInfoParam param) {
        Integer areaId = param.getAreaId();
        String date = param.getDate();
        String num = param.getNum();
        Double score = param.getScore();
        String title = param.getTitle();
        Integer articleId = param.getArticleId();
        String mainForm = param.getMainForm();
        String publicForm = param.getPublicForm();
        if (threeAreaInfoMapper.updateInfo(num, date, title, mainForm, publicForm, score, articleId, areaId) == 0)
            return CommonResult.fail("更新三区信息失败");
        return CommonResult.success("更新成功");
    }

    @Override
//    @CacheEvict(cacheNames = {"allData", "scoreList"})
    public CommonResult<String> updateAgreeInfo(InfoScoreParam param) {
        if (articleMapper.updateAgreeInfo(param.getInfo(), param.getScore(), param.getArticleId()) == 0)
            return CommonResult.fail("更新失败");
        return CommonResult.success("更新成功");
    }

    @Override
//    @CacheEvict(cacheNames = {"allData", "scoreList"})
    public CommonResult<String> updateLoseInfo(InfoScoreParam param) {
        if (articleMapper.updateLoseInfo(param.getInfo(), param.getScore(), param.getArticleId()) == 0)
            return CommonResult.fail("更新失败");
        return CommonResult.success("更新成功");
    }

    @Override
//    @CacheEvict(cacheNames = "allData")
    public CommonResult<String> updateAddInfo(StringParam param) {
        if (articleMapper.updateAddInfo(param.getParam(), param.getArticleId()) == 0) return CommonResult.fail("更新失败");
        return CommonResult.success("更新成功");
    }

}