package com.tyresshop.dao;

import com.tyresshop.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public interface TransactionDao {

    Transaction findByCustomerId(int customerIdent) throws SQLException;

    Boolean save(Transaction transaction) throws IOException;
}
