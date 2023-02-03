package com.tut.tutims.mapper;

import com.tut.tutims.pojo.domain.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    Department selectByName(String name);

    Department selectById(Integer departmentId);

    List<Department> selectAllDepartment();

    Integer addByNameAndType(String name, Integer typeId);
}
