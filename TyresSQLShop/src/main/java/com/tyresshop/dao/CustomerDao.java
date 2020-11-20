package com.tyresshop.dao;

import com.tyresshop.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerDao {

    Customer findByName(String login) throws SQLException;

    Boolean save(Customer customer) throws IOException;



}