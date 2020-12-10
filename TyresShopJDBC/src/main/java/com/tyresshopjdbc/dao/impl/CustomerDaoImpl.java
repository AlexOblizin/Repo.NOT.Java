package com.tyresshopjdbc.dao.impl;

import com.tyresshopjdbc.ConnectionManager;
import com.tyresshopjdbc.dao.CustomerDao;
import com.tyresshopjdbc.entity.Customer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    ConnectionManager cm = new ConnectionManager();
    Connection connection = cm.getConnection();

    public CustomerDaoImpl() throws IOException {
    }


    @Override
    public Customer findByName(String name) throws SQLException {

        if (connection != null) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("SELECT * FROM \"customers\" WHERE NAME=?");

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery(); //return SQL result

            if (resultSet.next()) {

                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                int discount = resultSet.getInt("discount");

                return new Customer(name, phone, password, discount);
            }

        }
        return null;
    }


    @Override
    public Boolean save(Customer customer) throws IOException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        if (connection != null) {

            try {
                PreparedStatement preparedStatement
                        = connection.prepareStatement("INSERT INTO \"customers\" " +
                        "(NAME,PHONE,PASSWORD,DISCOUNT) VALUES (?,?,?,?)");
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getPhone());
                preparedStatement.setString(3,
                        DigestUtils.md5DigestAsHex((customer.getPassword().getBytes())));
                preparedStatement.setInt(4, customer.getDiscount());

                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                return true;

            } catch (SQLException sqlExc) {
                sqlExc.printStackTrace();
            }
        }

        return false;
    }

    public int getIdByName(String name) throws SQLException {
        if (connection != null) {

            PreparedStatement preparedStatement
                    = connection.prepareStatement("SELECT ID FROM \"customers\" WHERE NAME=?");

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("id");

                return id;

            }

        }
        return -1;
    }

}
