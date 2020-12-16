package com.tyresshopjdbc.service;

import com.tyresshopjdbc.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public interface TransactionService {

    String findTransactionById (int id) throws SQLException;

    String registration (Transaction transaction) throws IOException, SQLException;

    String getAllTransactions () throws IOException, SQLException;

}
