package com.example.logsignsql.model;

public class RiceMealCat {

    String name;
    Integer imageurl;

    public RiceMealCat(String name, Integer imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}
