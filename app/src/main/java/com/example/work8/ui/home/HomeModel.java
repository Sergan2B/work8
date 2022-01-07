package com.example.work8.ui.home;

import java.io.Serializable;

public class HomeModel implements Serializable {
    private String tvLocation, tvNameLocation;
    private int ivLocation;

    public int getIvLocation() {
        return ivLocation;
    }

    public void setIvLocation(int ivLocation) {
        this.ivLocation = ivLocation;
    }

    public String getTvLocation() {
        return tvLocation;
    }

    public void setTvLocation(String tvLocation) {
        this.tvLocation = tvLocation;
    }

    public String getTvNameLocation() {
        return tvNameLocation;
    }

    public void setTvNameLocation(String tvNameLocation) {
        this.tvNameLocation = tvNameLocation;
    }

    public HomeModel(String tvLocation, String tvNameLocation) {
        this.tvLocation = tvLocation;
        this.tvNameLocation = tvNameLocation;
    }

    public HomeModel(int ivLocation,String tvLocation, String tvNameLocation) {
        this.tvLocation = tvLocation;
        this.tvNameLocation = tvNameLocation;
        this.ivLocation = ivLocation;
    }
}
