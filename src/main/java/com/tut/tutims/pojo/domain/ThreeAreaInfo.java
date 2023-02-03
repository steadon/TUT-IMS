package com.tut.tutims.pojo.domain;

import lombok.Data;

@Data
public class ThreeAreaInfo {
    private Integer id;
    private Integer areaId;
    private String num;
    private String date;
    private String title;
    private String mainForm;
    private String publicForm;
    private Double score;
}
