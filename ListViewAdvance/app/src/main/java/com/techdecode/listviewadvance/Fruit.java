package com.techdecode.listviewadvance;

public class Fruit {
    private String name;
    private String description;
    private int imageCode;

    public Fruit(String name, String description, int imageCode) {
        this.name = name;
        this.description = description;
        this.imageCode = imageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageCode() {
        return imageCode;
    }

    public void setImageCode(int imageCode) {
        this.imageCode = imageCode;
    }
}

