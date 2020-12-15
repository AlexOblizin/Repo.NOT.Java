package com.tyresshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tyres")
public class Tyres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int heigth;
    private int width;
    private int radius;
    private String model;
    private String type;
    private int price;


    public Tyres(int heigth, int width, int radius, String model, String type, int price) {
    }
}
