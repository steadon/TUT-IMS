package com.tut.tutims.entry.pojo;

import lombok.Data;

@Data
public class ReportInfo {
    private Integer id;
    private Integer articleId;
    private String pushNum;
    private String askNum;
    private String pushTitle;
    private String isAgree;
    private String signDate;
}
