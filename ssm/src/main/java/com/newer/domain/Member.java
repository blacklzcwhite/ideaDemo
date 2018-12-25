package com.newer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;


public class Member {

    private Integer mid;

    private String mname;

    private String mphone;

    private Integer mlevel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp mintime;

    private String mcardno;

    private String mimg;

    public Member() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public Integer getMlevel() {
        return mlevel;
    }

    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }

    public Timestamp getMintime() {
        return mintime;
    }

    public void setMintime(Timestamp mintime) {
        this.mintime = mintime;
    }

    public String getMcardno() {
        return mcardno;
    }

    public void setMcardno(String mcardno) {
        this.mcardno = mcardno;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }
}
