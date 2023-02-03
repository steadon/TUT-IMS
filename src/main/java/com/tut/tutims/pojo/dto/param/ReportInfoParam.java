package com.tut.tutims.pojo.dto.param;

import lombok.Data;

@Data
public class ReportInfoParam {
    private String pushNum;
    private String askNum;
    private String pushTitle;
    private String isAgree;
    private String signDate;
    private Integer articleId;
}
