package com.tyresshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "customer")
    List<Transaction> transactionList;

    private String name;
    private String phone;
    private String password;
    private int discount;


    public Customer(String name, String phone, String password, int discount) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.discount = discount;
    }
}
