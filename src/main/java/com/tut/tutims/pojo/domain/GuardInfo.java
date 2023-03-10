package com.tut.tutims.pojo.domain;

import lombok.Data;

@Data
public class GuardInfo {
    private Integer id;
    private Integer articleId;
    private Boolean isPublic;
    private String publicForm;
    private String mainForm;
    private String issueNum;
    private Double score;
}
