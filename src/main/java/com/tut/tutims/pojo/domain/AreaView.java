package com.tut.tutims.pojo.domain;

import lombok.Data;

@Data
public class AreaView {
    private Integer id;
    private Integer articleId;
    private String title;
    private String pushNum;
    private String useNum;
    private String date;
    private String department;
    private String author;
    private Integer areaId;
}
