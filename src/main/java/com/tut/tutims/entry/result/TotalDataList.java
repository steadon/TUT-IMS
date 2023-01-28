package com.tut.tutims.entry.result;

import com.tut.tutims.entry.param.TotalDataParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TotalDataList {
    List<TotalDataParam> paramList;
}
