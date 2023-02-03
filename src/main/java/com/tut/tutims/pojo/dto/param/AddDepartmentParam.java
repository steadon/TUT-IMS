package com.tut.tutims.pojo.dto.param;


import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class AddDepartmentParam {
    @NotBlank(message = "部门类型不能为空")
    private String type;
    @NotBlank(message = "部门名称不能为空")
    private String name;
}
