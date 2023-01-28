package com.tut.tutims.mapper;

import com.tut.tutims.entry.pojo.DepartmentType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentTypeMapper {
    DepartmentType selectByName(String name);

    Integer addByName(String name);
}
