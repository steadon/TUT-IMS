package com.tut.tutims.entry.pojo;

import lombok.Data;

@Data
public class GuardInfo {
    private Integer id;
    private Integer articleId;
    private Boolean isPublic;
    private String publicForm;
    private String mainForm;
    private Integer issueNum;
    private Double score;
}
