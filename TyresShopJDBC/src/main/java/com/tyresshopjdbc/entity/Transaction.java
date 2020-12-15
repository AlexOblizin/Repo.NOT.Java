package com.tyresshopjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int id;
    private int customerId;
    private int tyresId;
    private int quantity;
    private boolean installation;
    private int sum;


    public Transaction(int customerId, int tyresId, int quantity, boolean installation, int sum) {
        this.customerId = customerId;
        this.tyresId = tyresId;
        this.quantity = quantity;
        this.installation = installation;
        this.sum = sum;
    }
}
