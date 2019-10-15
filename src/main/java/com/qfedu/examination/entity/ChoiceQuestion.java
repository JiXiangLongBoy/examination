package com.qfedu.examination.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ChoiceQuestion {
    private Integer id;
    private Integer score;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;
    private Integer subjectId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sname;
}
