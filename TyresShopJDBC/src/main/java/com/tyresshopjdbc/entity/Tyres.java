package com.tyresshopjdbc.entity;

import lombok.Data;

@Data
public class Tyres {

    private int id;
    private int heigth;
    private int width;
    private int radius;
    private String model;
    private String type;
    private int price;


    public Tyres() {
    }

    public Tyres(int heigth, int width, int radius, String model, String type, int price) {
        this.heigth = heigth;
        this.width = width;
        this.radius = radius;
        this.model = model;
        this.type = type;
        this.price = price;
    }
}
