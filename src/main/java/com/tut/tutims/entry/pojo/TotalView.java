package com.tut.tutims.entry.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TotalView {
    //缺少首长批示和扣分情况
    private Integer id;
    private String department;
    private String title;
    private String author;
    private Integer weekNum;
    private String reportTime;
    //警备区
    private Boolean isPublic;
    private String publicForm;
    private String mainForm;
    private Integer issueNum;
    private Double guardScore;
    //上报
    private String pushNum;
    private String askNum;
    private String pushTitle;
    private String agreeList;
    private String signDate;
    //三区
    private String areaName;
    private String areaNum;
    private String areaDate;
    private String areaTitle;
    private String areaMainForm;
    private String areaPublicForm;
    private String areaScore;
}
