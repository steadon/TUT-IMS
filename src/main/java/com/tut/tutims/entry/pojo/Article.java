package com.tut.tutims.entry.pojo;

import lombok.Data;

@Data
public class Article {
    //缺少首长批示和扣分情况
    private Integer id;
    private Integer departmentId;
    private String title;
    private String author;
    private Integer week;
    private String time;
    private Integer guardInfoId;
    private Integer reportInfoId;
}
