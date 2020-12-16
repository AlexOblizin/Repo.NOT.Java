package com.tyresshopjdbc.service;

import com.tyresshopjdbc.dao.TransactionDao;
import com.tyresshopjdbc.dao.TyresDao;
import com.tyresshopjdbc.dao.impl.TransactionDaoImpl;
import com.tyresshopjdbc.dao.impl.TyresDaoImpl;
import com.tyresshopjdbc.entity.Transaction;
import com.tyresshopjdbc.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    TransactionDao transactionDao = new TransactionDaoImpl();

    public TransactionServiceImpl() throws IOException {
    }

    @Override
    public String findTransactionById(int id) throws SQLException {
        Transaction findTransaction = transactionDao.findByIdOfTransaction(id);

        if (id == 0) {
            return "No iD entered";
        }

        if (findTransaction != null) {
            if (id == findTransaction.getId()) {
                return "Ok! ===== transaction ID: " + id + " customer ID: "
                        + findTransaction.getCustomerId() + " tyres ID: "
                        + findTransaction.getTyresId() + " quantity: "
                        + findTransaction.getQuantity() + " installation: "
                        + findTransaction.isInstallation() + " sum: "
                        + findTransaction.getSum();
            }

        }

        return "No such position!";
    }

    @Override
    public String registration(Transaction transaction) throws IOException, SQLException {
        return null;
    }

    @Override
    public String getAllTransactions() throws IOException, SQLException {
        TransactionDao transactionDao = new TransactionDaoImpl();


        List<Transaction> transactionAll = transactionDao.getAll();
        String result = "";

        for (Transaction transaction : transactionAll) {
            result += "  next transaction (ID):  ";
            result += transaction.getId() + " customerID: "
                    + transaction.getCustomerId() + " tyresID: "
                    + transaction.getTyresId() + " quantity: "
                    + transaction.getQuantity() + " installation: "
                    + transaction.isInstallation() + " sum: "
                    + transaction.getSum();
        }

        return result;
    }
}
