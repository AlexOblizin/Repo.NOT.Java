package com.tyresshopjdbc.service;

import com.tyresshopjdbc.dao.TransactionDao;
import com.tyresshopjdbc.dao.impl.TransactionDaoImpl;
import com.tyresshopjdbc.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public class TransactionServiceImpl implements TransactionService{

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
}
