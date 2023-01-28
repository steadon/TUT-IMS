package com.tut.tutims.mapper;

import com.tut.tutims.entry.pojo.AreaView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaViewMapper {
    List<AreaView> selectAllById(Integer areaId);

}
