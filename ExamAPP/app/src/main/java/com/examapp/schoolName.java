package com.examapp;

public class schoolName {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public schoolName(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
