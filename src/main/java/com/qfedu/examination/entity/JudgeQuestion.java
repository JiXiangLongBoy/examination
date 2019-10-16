package com.qfedu.examination.entity;

import lombok.Data;

@Data
public class JudgeQuestion {
    private Integer id;
    private int score;
    private String question;
    private int answer;
    private int subjectID;
}
