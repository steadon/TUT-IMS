package com.tut.tutims.entry.result;

import com.tut.tutims.entry.pojo.TotalView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllDataList {
    List<TotalView> list;


}
