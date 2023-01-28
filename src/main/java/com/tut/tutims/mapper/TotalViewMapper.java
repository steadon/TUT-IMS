package com.tut.tutims.mapper;

import com.tut.tutims.entry.pojo.TotalView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TotalViewMapper {
    List<TotalView> selectAll();
}
