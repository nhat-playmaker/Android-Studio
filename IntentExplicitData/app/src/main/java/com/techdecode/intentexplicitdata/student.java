package com.techdecode.intentexplicitdata;

import java.io.Serializable;

public class student implements Serializable {
    private String name;
    private int year;

    public student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
