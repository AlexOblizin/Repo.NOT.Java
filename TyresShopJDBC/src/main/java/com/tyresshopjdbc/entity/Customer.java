package com.tyresshopjdbc.entity;

import lombok.Data;

@Data
public class Customer {

    private int id;
    private String name;
    private String phone;
    private String password;
    private int discount;

    public Customer(){

    }

    public Customer(String name, String phone, String password, int discount) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.discount = discount;
    }

}