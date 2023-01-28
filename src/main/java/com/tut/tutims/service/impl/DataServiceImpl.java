package com.tut.tutims.service.impl;

import com.tut.tutims.entry.CommonResult;
import com.tut.tutims.entry.param.*;
import com.tut.tutims.entry.pojo.*;
import com.tut.tutims.entry.result.DepartmentList;
import com.tut.tutims.entry.result.TotalDataList;
import com.tut.tutims.mapper.*;
import com.tut.tutims.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DataServiceImpl implements DataService {
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    TotalViewMapper totalViewMapper;
    @Resource
    ThreeAreaInfoMapper threeAreaInfoMapper;
    @Resource
    GuardInfoMapper guardInfoMapper;
    @Resource
    ReportInfoMapper reportInfoMapper;

    @Override
    public CommonResult<DepartmentList> getAllDepartment() {
        List<Department> departments = departmentMapper.selectAllDepartment();
        if (departments == null) return CommonResult.fail("暂未创建任何部门");
        DepartmentList list = new DepartmentList(departments);
        return CommonResult.success(list);
    }

    @Override
    public CommonResult<String> updateGuardInfo(GuardInfoParam param) {
        Integer articleId = param.getArticleId();
        Double score = param.getScore();
        Boolean isPublic = param.getIsPublic();
        Integer issueNum = param.getIssueNum();
        String mainForm = param.getMainForm();
        String publicForm = param.getPublicForm();
        if (guardInfoMapper.updateInfo(isPublic, publicForm, mainForm, issueNum, score, articleId) == 0)
            return CommonResult.fail("更新警备区信息失败");
        return CommonResult.success("更新成功");
    }

    @Override
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
    public CommonResult<TotalDataList> getScoreList() {

        Map<String, Integer> map = new HashMap<>();
        Map<String, DataParam> mapG = new HashMap<>();
        Map<String, DataParam> mapA = new HashMap<>();
        Map<String, DataParam> mapB = new HashMap<>();
        Map<String, DataParam> mapC = new HashMap<>();

        for (TotalView totalView : totalViewMapper.selectAll()) {
            //记录部门发文总数
            String department = totalView.getDepartment();
            if (map.containsKey(department)) {
                Integer integer = map.get(department);
                map.put(department, ++integer);
            } else {
                map.put(department, 1);
                mapG.put(department, new DataParam());
                mapA.put(department, new DataParam());
                mapB.put(department, new DataParam());
                mapC.put(department, new DataParam());
            }
            //警备区刊用形式
            String publicForm = totalView.getPublicForm();
            final DataParam moreDataParam = mapG.get(department);

            updateCount(publicForm, moreDataParam);
            //上报要讯编号->判断是否上报
            String pushNum = totalView.getPushNum();
            if (pushNum != null) {
                //有编号，上报计数+1
                Integer push = moreDataParam.getPush();
                moreDataParam.setPush(++push);
                Double score = moreDataParam.getScore();
                moreDataParam.setScore(score + 0.5);
                //三区刊用形式
                String areaPublicForm = totalView.getAreaPublicForm();
                //三区分别刊用形式
                String[] split = areaPublicForm.split(",");
                final DataParam dataParamA = mapA.get(department);
                updateCount(split[0], dataParamA);
                final DataParam dataParamB = mapB.get(department);
                updateCount(split[1], dataParamB);
                final DataParam dataParamC = mapC.get(department);
                updateCount(split[2], dataParamC);
            }
        }

        List<TotalDataParam> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            map.forEach((k, v) -> {
                Integer id = departmentMapper.selectByName(k).getId();
                DataParam paramG = mapG.get(k);
                Double scoreG = paramG.getScore();
                DataParam paramA = mapA.get(k);
                Double scoreA = paramA.getScore();
                DataParam paramB = mapB.get(k);
                Double scoreB = paramB.getScore();
                DataParam paramC = mapC.get(k);
                Double scoreC = paramC.getScore();
                TotalDataParam param = new TotalDataParam(id, k, v, paramG, paramA, paramB, paramC, 0.0, 0.0, scoreG + scoreA + scoreB + scoreC);
                list.add(param);
            });
        }
        TotalDataList totalDataList = new TotalDataList(list);
        return CommonResult.success(totalDataList);
    }

    public void updateCount(String publicForm, DataParam moreDataParam) {
        //枚举属性
        Integer num2 = moreDataParam.getNum2();
        Integer num3 = moreDataParam.getNum3();
        Integer num4 = moreDataParam.getNum4();
        Integer num5 = moreDataParam.getNum5();
        Integer num6 = moreDataParam.getNum6();
        Integer more = moreDataParam.getMore();
        Integer push = moreDataParam.getPush();
        Integer special = moreDataParam.getSpecial();
        //分类统计
        switch (publicForm) {
            case "专报" -> moreDataParam.setNum2(++num2);

            case "单条" -> moreDataParam.setNum3(++num3);

            case "综合" -> moreDataParam.setNum4(++num4);

            case "简讯" -> moreDataParam.setNum5(++num5);

            case "要目" -> moreDataParam.setNum6(++num6);

            case "增刊" -> moreDataParam.setMore(++more);

            case "专刊" -> moreDataParam.setSpecial(++special);

            case "暂无" -> {
                return;
            }
            default -> log.info("error push_form");
        }
        //更新总数
        int total = num2 + num3 + num4 + num5 + num6 + more + push + special;
        moreDataParam.setTotal(total);
        //算分公式
        double score = 2 * num3 + 2 * num4 + num5 + 0.2 * num6 + 2 * special;
        moreDataParam.setScore(score);
    }
}

