package com.tyresshopjdbc.dao;

import com.tyresshopjdbc.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {

    List<Transaction> listOfCustomersIds(int customerIdentificator) throws SQLException;

    Transaction findByIdOfTransaction(int idOfTransaction) throws SQLException;

    Boolean save (Transaction transaction) throws IOException;

}
