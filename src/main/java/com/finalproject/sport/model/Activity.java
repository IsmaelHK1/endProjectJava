package com.finalproject.sport.model;

import java.util.Date;

public class Activity {

    public Activity(String name, int duration, Date date, int RPE, int load) {
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.RPE = RPE;
        this.load = load;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRPE() {
        return RPE;
    }

    public void setRPE(Integer RPE) {
        this.RPE = RPE;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    private String name;
    private int duration;
    private Date date;
    private int RPE;
    private int load;

}
