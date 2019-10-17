package com.qfedu.examination.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ExamTime {
    private int id;
    private int sID;
    private Date begin;
    private Date end;
    private int duration;

    private String sName;

}
