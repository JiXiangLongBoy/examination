package com.qfedu.examination.entity;

import lombok.Data;

@Data
public class JudgeQuestion {
    private int id;
    private int score;
    private String question;
    private int answer;
    private int subjectID;
}
