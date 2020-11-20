package com.tyresshop.entity;

import lombok.Data;

@Data
public class Customer {

    private int id;
    private String name;
    private String phone;
    private String password;
    private int discount;


    public Customer(int id, String name, String phone, String password, int discount) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.discount = discount;
    }
}
