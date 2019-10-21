package com.qfedu.examination.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ExamTime {
    private int id;
    private Integer sID;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begins;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ends;

    private String beginTime;
   private String endTime;


    @ApiModelProperty(hidden = true)
    private int duration;

    @ApiModelProperty(hidden = true)
    private String sName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public Date getBegins() {

        return begins;
    }

    public void setBegins(Date begins) {

        this.begins = begins;
    }

    public Date getEnds() {
        return ends;
    }

    public void setEnds(Date ends) {
        this.ends = ends;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getBeginTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(this.begins);
        this.beginTime=format;
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        Date parse = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
             parse = simpleDateFormat.parse(beginTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.begins=parse;
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(this.ends);
        this.endTime=format;
        return endTime;
    }

    public void setEndTime(String endTime) {
        Date parse = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            parse = simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.ends=parse;
        this.endTime = endTime;
    }
}
