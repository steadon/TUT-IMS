package com.tut.tutims.mapper;

import com.tut.tutims.pojo.domain.GuardInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuardInfoMapper {
    Integer addOne(Integer articleId);

    Integer updateInfo(Boolean isPublic, String publicForm, String mainForm, Integer issueNum, Double score, Integer articleId);

    Integer selectNewId();

    List<GuardInfo> selectAll();
}
