package com.tyresshopjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tyres {

    private int id;
    private int heigth;
    private int width;
    private int radius;
    private String model;
    private String type;
    private int price;


    public Tyres(int heigth, int width, int radius, String model, String type, int price) {
        this.heigth = heigth;
        this.width = width;
        this.radius = radius;
        this.model = model;
        this.type = type;
        this.price = price;
    }

//    public String toString()
//    {
//        return id + " - " + model + " - " + heigth + " - " +
//               width + " - " + radius + " - " +
//               type + " - " + price;
//    }
}
