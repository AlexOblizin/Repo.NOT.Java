package com.tyresshopjdbc.service;

import com.tyresshopjdbc.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    String login(String login, String password) throws SQLException;

    String registration(Customer customer) throws IOException, SQLException;

    String deleteCustomer(String name) throws IOException, SQLException;

    String editCustomer(int id, String name, String phone, String password, int discount) throws IOException, SQLException;

    String getAllCustomers() throws SQLException, IOException;

    List<Customer> getAllCustomers2() throws SQLException, IOException;

}
