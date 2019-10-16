package com.qfedu.examination.entity;

import lombok.Data;

@Data
public class ShortQuestion {
    private Integer id;
    private int score;
    private String question;
    private String answer;
    private int subjectID;
}
