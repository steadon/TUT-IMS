package com.tut.tutims.pojo.dto.param;

import lombok.Data;

@Data
public class GuardInfoParam {
    private String isPublic;
    private String publicForm;
    private String mainForm;
    private String issueNum;
    private String score;
    private Integer articleId;
}
