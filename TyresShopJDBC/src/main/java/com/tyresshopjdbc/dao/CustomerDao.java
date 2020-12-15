package com.tyresshopjdbc.dao;

import com.tyresshopjdbc.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerDao {

    Customer findByName(String login) throws SQLException;

    Boolean save (Customer customer) throws IOException;

    int getIdByName(String name) throws SQLException;



}
