package com.tut.tutims.pojo.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class AddArticleParam {
    @NotNull(message = "部门不能为空")
    private Integer departmentId;
    @NotBlank(message = "要讯题目不能为空")
    private String title;
    @NotBlank(message = "撰稿者不能为空")
    private String author;
    private Integer weekNum;
    private String time;
}
