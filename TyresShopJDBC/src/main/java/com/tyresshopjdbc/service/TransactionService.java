package com.tyresshopjdbc.service;

import com.tyresshopjdbc.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public interface TransactionService {

    public String findTransactionById (int id) throws SQLException;

    public String registration (Transaction transaction) throws IOException, SQLException;
}
