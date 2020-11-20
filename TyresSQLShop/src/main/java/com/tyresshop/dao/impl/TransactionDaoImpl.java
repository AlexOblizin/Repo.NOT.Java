package com.tyresshop.dao.impl;

import com.tyresshop.ConnectionManager;
import com.tyresshop.dao.TransactionDao;
import com.tyresshop.entity.Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();

    public TransactionDaoImpl() throws IOException {
    }

    @Override
    public Transaction findByCustomerId(int customerIdent) throws SQLException {
        Transaction transaction = null;
        if (con != null) {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM \"Transactions\" where CUSTOMERID=?");
            pr.setInt(1, customerIdent);
            ResultSet resultSet = pr.executeQuery();//return sql result

            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                int tyresId = resultSet.getInt("tyresId");
                int quantity = resultSet.getInt("quantity");
                boolean installation = resultSet.getBoolean("installation");
                int sum = resultSet.getInt("sum");


                transaction =
                        new Transaction(id, customerId, tyresId, quantity, installation, sum);


                return transaction;
            }
            pr.close();
            con.close();
        }
        return transaction;

    }


    @Override
    public Boolean save(Transaction transaction) throws IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr =
                        con.prepareStatement("INSERT INTO \"Customers\" (ID,CUSTOMERID,TRANSACTIONID,QUANTITY,INSTALLATION,SUM)" +
                                " VALUES (?,?,?,?,?,?)");
                pr.setInt(1, transaction.getId());
                pr.setInt(2, transaction.getCustomerId());
                pr.setInt(3, transaction.getTyresId());
                pr.setInt(4, transaction.getQuantity());
                pr.setBoolean(5, transaction.getInstallation());
                pr.setInt(6, transaction.getSum());


                pr.executeUpdate();
                pr.close();
                con.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
