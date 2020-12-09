package com.tyresshopjdbc.service;

import com.tyresshopjdbc.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerService {

public String login (String login, String password) throws SQLException;

public String registration (Customer customer) throws IOException, SQLException;


}
