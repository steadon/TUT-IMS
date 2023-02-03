package com.tut.tutims.pojo.domain;

import lombok.Data;

@Data
public class TotalViewParam {
    //基本信息
    private Integer id;
    private String department;
    private String title;
    private String author;
    private String weekNum;
    private String reportTime;
    //警备区
    private String isPublic;
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
    //三区1
    private String areaName1;
    private String areaNum1;
    private String areaDate1;
    private String areaTitle1;
    private String areaMainForm1;
    private String areaPublicForm1;
    private String areaScore1;
    //三区2
    private String areaName2;
    private String areaNum2;
    private String areaDate2;
    private String areaTitle2;
    private String areaMainForm2;
    private String areaPublicForm2;
    private String areaScore2;
    //三区3
    private String areaName3;
    private String areaNum3;
    private String areaDate3;
    private String areaTitle3;
    private String areaMainForm3;
    private String areaPublicForm3;
    private String areaScore3;
    //首长批示及扣分
    private String agreeInfo;
    private Double agreeScore;
    private String loseInfo;
    private Double loseScore;
    //备注
    private String addInfo;

    public TotalViewParam(TotalView view) {
        //前端让这么干的
        String areaName = view.getAreaName();
        String[] split = areaName.split(",");
        String areaDate = view.getAreaDate();
        String[] split1 = areaDate.split(",");
        String areaTitle = view.getAreaTitle();
        String[] split2 = areaTitle.split(",");
        String areaNum = view.getAreaNum();
        String[] split3 = areaNum.split(",");
        String areaMainForm = view.getAreaMainForm();
        String[] split4 = areaMainForm.split(",");
        String areaPublicForm = view.getAreaPublicForm();
        String[] split5 = areaPublicForm.split(",");
        String areaScore = view.getAreaScore();
        String[] split6 = areaScore.split(",");

        this.id = view.getId();
        this.department = view.getDepartment();
        this.title = view.getTitle();
        this.author = view.getAuthor();
        this.weekNum = "第" + view.getWeekNum() + "周";
        this.reportTime = view.getReportTime();
        if (view.getIsPublic()) {
            this.isPublic = "是";
        } else {
            this.isPublic = "否";
        }
        this.publicForm = view.getPublicForm();
        this.mainForm = view.getMainForm();
        this.issueNum = view.getIssueNum() + "号";
        this.guardScore = view.getGuardScore();
        this.pushNum = view.getPushNum();
        this.askNum = view.getAskNum();
        this.pushTitle = view.getPushTitle();
        this.agreeList = view.getAgreeList();
        this.signDate = view.getSignDate();

        this.areaName1 = split[0];
        this.areaNum1 = split3[0];
        this.areaDate1 = split1[0];
        this.areaTitle1 = split2[0];
        this.areaMainForm1 = split4[0];
        this.areaPublicForm1 = split5[0];
        this.areaScore1 = split6[0];

        this.areaName2 = split[1];
        this.areaNum2 = split3[1];
        this.areaDate2 = split1[1];
        this.areaTitle2 = split2[1];
        this.areaMainForm2 = split4[1];
        this.areaPublicForm2 = split5[1];
        this.areaScore2 = split6[1];

        this.areaName3 = split[2];
        this.areaNum3 = split3[2];
        this.areaDate3 = split1[2];
        this.areaTitle3 = split2[2];
        this.areaMainForm3 = split4[2];
        this.areaPublicForm3 = split5[2];
        this.areaScore3 = split6[2];

        this.agreeInfo = view.getAgreeInfo();
        this.agreeScore = view.getAgreeScore();
        this.loseInfo = view.getLoseInfo();
        this.loseScore = view.getLoseScore();
        this.addInfo = view.getAddInfo();
    }
}
