package com.techdecode.galleryapp;

public class Images {
    private String name;
    private int imageCode;

    public Images(String name, int imageCode) {
        this.name = name;
        this.imageCode = imageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageCode() {
        return imageCode;
    }

    public void setImageCode(int imageCode) {
        this.imageCode = imageCode;
    }


}
