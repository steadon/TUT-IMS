package com.tut.tutims.pojo.dto.result;

import com.tut.tutims.pojo.domain.AreaView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AreaViewList {
    private List<AreaView> viewList;
}
