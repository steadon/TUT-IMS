package com.tut.tutims.entry.param;

import lombok.Data;

@Data
public class GuardInfoParam {
    Boolean isPublic;
    String publicForm;
    String mainForm;
    Integer issueNum;
    Double score;
    Integer articleId;
}
