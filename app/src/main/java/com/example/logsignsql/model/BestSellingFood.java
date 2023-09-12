package com.example.logsignsql.model;

public class BestSellingFood {

    String name;
    String price;
    Integer imageurl;

    public BestSellingFood(String name, String price, Integer imageurl) {
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}
