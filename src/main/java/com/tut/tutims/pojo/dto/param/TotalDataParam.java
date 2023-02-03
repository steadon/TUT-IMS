package com.tut.tutims.pojo.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalDataParam {
    private Integer id;
    private String name;
    private Integer pushNum;
    private DataParam param1;
    private DataParam param2;
    private DataParam param3;
    private DataParam param4;
    private Double agreeScore;
    private Double loseScore;
    private Double totalScore;
}
