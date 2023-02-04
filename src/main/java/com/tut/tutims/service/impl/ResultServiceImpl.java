package com.tut.tutims.service.impl;

import com.tut.tutims.mapper.AreaViewMapper;
import com.tut.tutims.mapper.DepartmentMapper;
import com.tut.tutims.mapper.TotalViewMapper;
import com.tut.tutims.pojo.CommonResult;
import com.tut.tutims.pojo.domain.AreaView;
import com.tut.tutims.pojo.domain.TotalView;
import com.tut.tutims.pojo.dto.param.DataParam;
import com.tut.tutims.pojo.dto.param.ScoreParam;
import com.tut.tutims.pojo.dto.param.TotalDataParam;
import com.tut.tutims.pojo.dto.result.AreaViewList;
import com.tut.tutims.pojo.dto.result.TotalDataList;
import com.tut.tutims.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    AreaViewMapper areaViewMapper;
    @Resource
    TotalViewMapper totalViewMapper;
    @Resource
    DepartmentMapper departmentMapper;

    @Override
//    @Cacheable(cacheNames = "areaView")
    public CommonResult<AreaViewList> consumeInfo(Integer areaId) {
        List<AreaView> areaViews = areaViewMapper.selectAllById(areaId);
        //添加索引
        for (int i = 0, j = 1; i < areaViews.size(); i++, j++) {
            AreaView areaView = areaViews.get(i);
            areaView.setId(j);
        }
        AreaViewList areaViewList = new AreaViewList(areaViews);
        return CommonResult.success(areaViewList);
    }

    @Override
//    @Cacheable(cacheNames = "scoreList")
    public CommonResult<TotalDataList> getScoreList() {

        Map<String, Integer> map = new HashMap<>();
        Map<String, ScoreParam> mapE = new HashMap<>();
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
                mapE.put(department, new ScoreParam());
            }
            //统计加分扣分
            Double agreeScore = totalView.getAgreeScore();
            Double loseScore = totalView.getLoseScore();
            //解决空指针安全
            if (agreeScore == null) agreeScore = 0.0d;
            if (loseScore == null) loseScore = 0.0d;
            ScoreParam scoreParam = mapE.get(department);
            Double originAS = scoreParam.getAgreeScore();
            scoreParam.setAgreeScore(originAS + agreeScore);
            Double originLS = scoreParam.getLoseScore();
            scoreParam.setLoseScore(originLS + loseScore);

            //警备区刊用形式
            String publicForm = totalView.getPublicForm();
            final DataParam moreDataParam = mapG.get(department);
            if (publicForm != null) updateCount(publicForm, moreDataParam);
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
                if (split[0] != null) updateCount(split[0], dataParamA);
                final DataParam dataParamB = mapB.get(department);
                if (split[1] != null) updateCount(split[1], dataParamB);
                final DataParam dataParamC = mapC.get(department);
                if (split[2] != null) updateCount(split[2], dataParamC);
            }
        }

        List<TotalDataParam> list = new ArrayList<>();

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
            ScoreParam scoreParam = mapE.get(k);
            Double agreeScore = scoreParam.getAgreeScore();
            Double loseScore = scoreParam.getLoseScore();
            TotalDataParam param = new TotalDataParam(id, k, v, paramG, paramA, paramB, paramC, agreeScore, loseScore, scoreG + scoreA + scoreB + scoreC + agreeScore - loseScore);
            list.add(param);
        });

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
