package com.tut.tutims.entry.result;

import com.tut.tutims.entry.pojo.Department;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentList {
    List<Department> departmentList;
}
