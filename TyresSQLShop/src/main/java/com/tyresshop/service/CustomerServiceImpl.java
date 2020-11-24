package com.tyresshop.service;

import com.tyresshop.dao.impl.CustomerDaoImpl;
import com.tyresshop.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {


    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public CustomerServiceImpl() throws IOException {
    }


    @Override
    public String login(String name, String pass) throws SQLException {
        Customer findCustomer = customerDao.findByName(name);
        if (pass == null) {
            return "No password entered";
        }
        if (findCustomer != null) {
            if ((pass.equals(findCustomer.getPassword()))) {
                return "Ok! Customer iD is: " + customerDao.getIdByName(name);
            }

        }
        return "Authorization failed!";
    }

    @Override
    public String registration(Customer customer) throws IOException, SQLException {
        Customer findCustomer = customerDao.findByName(customer.getName());
        if (findCustomer == null) {
            customerDao.save(customer);
            return "Fine!";
        }
        return "this login is not available";
    }


}
