package com.tut.tutims.pojo.dto.result;

import com.tut.tutims.pojo.dto.param.TotalDataParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TotalDataList {
    private List<TotalDataParam> paramList;
}
