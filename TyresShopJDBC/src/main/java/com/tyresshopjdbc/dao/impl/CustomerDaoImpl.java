package com.tyresshopjdbc.dao.impl;

import com.tyresshopjdbc.ConnectionManager;
import com.tyresshopjdbc.dao.CustomerDao;
import com.tyresshopjdbc.entity.Customer;
import com.tyresshopjdbc.entity.Transaction;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Customer findById(int id) throws SQLException {
        if (connection != null) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("SELECT * FROM \"customers\" WHERE ID=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(); //return SQL result

            if (resultSet.next()) {

                String name = resultSet.getString("name");
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

    @Override
    public Boolean deleteCustomer(String name) throws IOException, SQLException {

        Connection connection = new ConnectionManager().getConnection();

        if (connection != null) {

            try {
                PreparedStatement preparedStatement
                        = connection.prepareStatement("DELETE FROM \"customers\" WHERE NAME=?;");
                preparedStatement.setString(1, name);


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

    @Override
    public Boolean editCustomer(int id, String name, String phone, String password, int discount) throws IOException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        if (connection != null) {

            try {
                PreparedStatement preparedStatement
                        = connection.prepareStatement
                        ("UPDATE \"customers\" SET NAME=?, PHONE=?, PASSWORD=?, DISCOUNT=? WHERE ID=?;");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phone);
                preparedStatement.setString(3, DigestUtils.md5DigestAsHex(password.getBytes()));
                preparedStatement.setInt(4, discount);
                preparedStatement.setInt(5, id);

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

    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"customers\";");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                int discount = resultSet.getInt("discount");

                Customer customer = new Customer(id, name, phone, discount);
                customerList.add(customer);
            }

        }

        return customerList;
    }

}
