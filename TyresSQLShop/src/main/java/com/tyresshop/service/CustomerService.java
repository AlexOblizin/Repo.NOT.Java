package com.tyresshop.service;

import com.tyresshop.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerService {

    public String login(String name, String pass) throws SQLException;


    public String registration(Customer customer) throws IOException, SQLException;

}
