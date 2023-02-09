package com.tut.tutims.pojo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TotalView {
    //基本信息
    private Integer id;
    private String department;
    private String title;
    private String author;
    private String reportTime;
    //警备区
    private Boolean isPublic;
    private String publicForm;
    private String mainForm;
    private String issueNum;
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
    //首长批示及扣分
    private String agreeInfo;
    private Double agreeScore;
    private String loseInfo;
    private Double loseScore;
    //备注
    private String addInfo;
}
