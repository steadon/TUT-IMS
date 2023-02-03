package com.tut.tutims.pojo.dto.result;

import com.tut.tutims.pojo.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentList {
    private List<Department> departmentList;
}
