package com.tut.tutims.pojo.dto.result;

import com.tut.tutims.pojo.dto.param.TotalViewParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllDataList {
    private List<TotalViewParam> list;
}
