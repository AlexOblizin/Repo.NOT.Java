package com.tyresshop.entity;

import lombok.Data;

@Data
public class Transaction {
    private int id;
    private int customerId;
    private int tyresId;
    private int quantity;
    private boolean installation;
    private int sum;

    public Transaction(int id, int customerId, int tyresId, int quantity, boolean installation, int sum) {
        this.id = id;
        this.customerId = customerId;
        this.tyresId = tyresId;
        this.quantity = quantity;
        this.installation = installation;
        this.sum = sum;
    }

    public boolean getInstallation() {
        return installation;
    }
}
