package com.tyresshop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "tyresid")
    private Tyres tyres;

    @Transient
    private int customerId;

    @Transient
    private int tyresId;



    private int quantity;
    private boolean installation;
    private int sum;


    public Transaction(int id, Customer customer, Tyres tyres, int quantity, boolean installation, int sum) {
        this.id = id;
        this.customer = customer;
        this.tyres = tyres;
        this.quantity = quantity;
        this.installation = installation;
        this.sum = sum;
    }

    public Transaction(int id, int customerId, int tyresId, int quantity, boolean installation, int sum) {
        this.id = id;
        this.customerId = customerId;
        this.tyresId = tyresId;
        this.quantity = quantity;
        this.installation = installation;
        this.sum = sum;
    }
}
