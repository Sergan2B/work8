package com.example.work8.ui.dashboard;

import java.io.Serializable;

public class DashboardModel implements Serializable {
    private String tvStatus, tvName;

    public String getTvStatus() {
        return tvStatus;
    }

    public void setTvStatus(String tvStatus) {
        this.tvStatus = tvStatus;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public Integer getIvInteger() {
        return ivInteger;
    }

    public void setIvInteger(Integer ivInteger) {
        this.ivInteger = ivInteger;
    }

    private Integer ivInteger;


    public DashboardModel(String tvStatus, String tvName, Integer ivInteger) {
        this.tvStatus = tvStatus;
        this.tvName = tvName;
        this.ivInteger = ivInteger;
    }
}
