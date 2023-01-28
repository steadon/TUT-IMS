package com.tut.tutims.entry.param;

import lombok.Data;

@Data
public class ReportInfoParam {
    String pushNum;
    String askNum;
    String pushTitle;
    String isAgree;
    String signDate;
    Integer articleId;
}
