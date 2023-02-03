package com.tut.tutims.pojo.dto.param;

import lombok.Data;

@Data
public class GuardInfoParam {
    private Boolean isPublic;
    private String publicForm;
    private String mainForm;
    private Integer issueNum;
    private Double score;
    private Integer articleId;
}
