package com.devcreature.moderndashboard.model;

public class MenuModel {
    private String name;
    private int image;
    private int color;

    public MenuModel() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() { return image; }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColor() { return color; }

    public void setColor(int color) { this.color = color; }
}
