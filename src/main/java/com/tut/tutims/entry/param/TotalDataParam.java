package com.tut.tutims.entry.param;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalDataParam {
    Integer id;
    String name;
    Integer pushNum;
    DataParam param1;
    DataParam param2;
    DataParam param3;
    DataParam param4;
    Double agreeScore;
    Double loseScore;
    Double totalScore;
}
