package com.tut.tutims.entry.param;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddArticleParam {
    Integer departmentId;
    String title;
    String author;
    Integer weekNum;
    String time;
}
