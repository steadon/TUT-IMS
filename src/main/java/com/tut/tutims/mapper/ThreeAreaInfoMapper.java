package com.tut.tutims.mapper;

import com.tut.tutims.pojo.domain.ThreeAreaInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThreeAreaInfoMapper {
    Integer addOne(Integer articleId);

    Integer updateInfo(String num, String date, String title, String mainForm, String publicForm, Double score, Integer articleId, Integer areaId);

    List<Integer> selectForNewTree();

    List<ThreeAreaInfo> selectAll();
}
