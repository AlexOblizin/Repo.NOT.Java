package com.tyresshop.dao;

import com.tyresshop.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {

    List<Transaction> findByCustomerId(int customerIdent) throws SQLException;

    Transaction findById(int customerIdent) throws SQLException;


    Boolean save(Transaction transaction) throws IOException;
}
