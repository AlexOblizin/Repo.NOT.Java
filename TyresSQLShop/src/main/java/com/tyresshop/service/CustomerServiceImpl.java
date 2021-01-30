package com.tyresshop.service;

import com.tyresshop.entity.Customer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {



    public CustomerServiceImpl() throws IOException {
    }


    @Override
    public String login(String name, String pass) throws SQLException {
        return null;
    }

    @Override
    public String registration(Customer customer) throws IOException, SQLException {
        return null;
    }
}
