package com.tut.tutims.pojo.dto.param;

import lombok.Data;

@Data
public class AreaInfoParam {
    private String num;
    private String date;
    private String title;
    private String mainForm;
    private String publicForm;
    private Double score;
    private Integer articleId;
    private Integer areaId;
}
