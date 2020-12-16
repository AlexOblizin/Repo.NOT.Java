package com.tyresshopjdbc.dao;

import com.tyresshopjdbc.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    Customer findByName(String login) throws SQLException;

    Customer findById(int id) throws SQLException;

    Boolean save (Customer customer) throws IOException;

    int getIdByName(String name) throws SQLException;

    Boolean deleteCustomer (String name) throws IOException, SQLException;

    Boolean editCustomer (int id, String name, String phone, String password, int discount) throws IOException, SQLException;

    List<Customer> getAll() throws SQLException;




}
