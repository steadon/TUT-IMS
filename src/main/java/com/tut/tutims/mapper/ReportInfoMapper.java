package com.tut.tutims.mapper;

import com.tut.tutims.entry.pojo.ReportInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportInfoMapper {
    Integer addOne(Integer articleId);

    Integer updateInfo(String pushNum, String askNum, String pushTitle, String isAgree, String signDate, Integer articleId);

    Integer selectNewId();

    List<ReportInfo> selectAll();
}
