package com.tut.tutims.mapper;

import com.tut.tutims.pojo.domain.AreaView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaViewMapper {
    List<AreaView> selectAllById(Integer areaId);

}
