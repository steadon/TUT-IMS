package com.tut.tutims.entry.result;

import com.tut.tutims.entry.pojo.AreaView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AreaViewList {
    List<AreaView> viewList;
}
