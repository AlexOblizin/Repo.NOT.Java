package com.tyresshopjdbc.dao.impl;

import com.tyresshopjdbc.ConnectionManager;
import com.tyresshopjdbc.dao.TransactionDao;
import com.tyresshopjdbc.entity.Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    ConnectionManager connectionManager = new ConnectionManager();
    Connection connection = connectionManager.getConnection();

    public TransactionDaoImpl() throws IOException {
    }


    @Override
    public List<Transaction> listOfCustomersIds(int customerIdentificator) throws SQLException {
        List<Transaction> result = new ArrayList<>();
        if (connection != null) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"transactions\" WHERE CUSTOMERID=?");
            preparedStatement.setInt(1, customerIdentificator);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int customerId = resultSet.getInt("customerId");
                int tyresId = resultSet.getInt("tyresId");
                int quantity = resultSet.getInt("quantity");
                boolean installation = resultSet.getBoolean("installation");
                int sum = resultSet.getInt("sum");

                Transaction transaction = new Transaction(customerId, tyresId, quantity, installation, sum);
                result.add(transaction);
            }
            preparedStatement.close();
            connection.close();

        }

        return result;
    }

    @Override
    public Transaction findByIdOfTransaction(int idOfTransaction) throws SQLException {
        if (connection != null) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("SELECT * FROM \"transaction\" WHERE CUSTOMERID=?");

            preparedStatement.setInt(1, idOfTransaction);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                int customerId = resultSet.getInt("customerId");
                int tyresId = resultSet.getInt("tyresId");
                int quantity = resultSet.getInt("quantity");
                boolean installation = resultSet.getBoolean("installation");
                int sum = resultSet.getInt("sum");

                return new Transaction(customerId, tyresId, quantity, installation, sum);
            }

        }

        return null;
    }

    @Override
    public Boolean save(Transaction transaction) throws IOException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement
                        = connection.prepareStatement("INSERT INTO \"transactions\" " +
                        "(CUSTOMERID,TYRESID,QUANTITY,INSTALLATION,SUM) VALUES (?,?,?,?,?)");
                preparedStatement.setInt(1, transaction.getCustomerId());
                preparedStatement.setInt(2, transaction.getTyresId());
                preparedStatement.setInt(3, transaction.getQuantity());
                preparedStatement.setBoolean(4, transaction.isInstallation());
                preparedStatement.setInt(5, transaction.getSum());

                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                return true;

            } catch (SQLException sqlExc) {

                sqlExc.printStackTrace();
            } catch (Exception exc) {
                exc.printStackTrace();
            }

        }

        return false;
    }
}
