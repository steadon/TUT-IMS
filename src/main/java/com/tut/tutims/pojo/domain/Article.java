package com.tut.tutims.pojo.domain;

import lombok.Data;

@Data
public class Article {
    private Integer id;
    private Integer departmentId;
    private String title;
    private String author;
    private Integer week;
    private String time;
    private Integer guardInfoId;
    private Integer reportInfoId;
    private String agreeInfo;
    private Double agreeScore;
    private String loseInfo;
    private Double loseScore;
    private String addInfo;
}
