package com.tyresshop.dao.impl;

import com.tyresshop.ConnectionManager;
import com.tyresshop.dao.CustomerDao;
import com.tyresshop.entity.Customer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();

    public CustomerDaoImpl() throws IOException {
    }

    @Override
    public Customer findByName(String name) throws SQLException {
        Customer customer = null;
        if (con != null) {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM \"Customers\" where NAME=?");
            pr.setString(1, name);
            ResultSet resultSet = pr.executeQuery();//return sql result

            if (resultSet.next()) {

                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");

                customer = new Customer(name, phone, password, 0);


                return customer;
            }
            pr.close();
            con.close();
        }
        return customer;

    }
    public int getIdByName(String name) throws SQLException {
        if (con != null) {
            PreparedStatement pr = con.prepareStatement("SELECT ID FROM \"Customers\" where NAME=?");
            pr.setString(1, name);
            ResultSet resultSet = pr.executeQuery();//return sql result

            if (resultSet.next()) {

                int id = resultSet.getInt("id");


                return id;
            }
            pr.close();
            con.close();
        }
        return -1;

    }


    @Override
    public Boolean save(Customer customer) throws IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("INSERT INTO \"Customers\" (ID,NAME,PHONE,PASSWORD,DISCOUNT) VALUES (?,?,?,?,?)");
                pr.setInt(1, customer.getId());
                pr.setString(2, customer.getName());
                pr.setString(3, customer.getPhone());
                pr.setString(4, DigestUtils.md5DigestAsHex((customer.getPassword()).getBytes()));
                pr.setInt(5, customer.getDiscount());

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
