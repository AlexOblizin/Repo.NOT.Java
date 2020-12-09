package com.tyresshopjdbc.service;

import com.tyresshopjdbc.dao.CustomerDao;
import com.tyresshopjdbc.dao.impl.CustomerDaoImpl;
import com.tyresshopjdbc.entity.Customer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    public CustomerServiceImpl() throws IOException {
    }


    @Override
    public String login(String login, String password) throws SQLException {
        Customer findCustomer = customerDao.findByName(login);
        if (password == null) {
            return "no password entered!";
        }
        if (findCustomer != null){
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (password.equals(findCustomer.getPassword())) {
                return "OK! Customer ID is: " + customerDao.findByName(login);
            }
        }

            return "Authorization failed!";
    }

    @Override
    public String registration(Customer customer) throws IOException, SQLException {
        Customer findCustomer = customerDao.findByName(customer.getName());
        if(findCustomer == null) {
            customerDao.save(customer);
            return "Fine!";
        }

        return "This login is not available!";

    }
}
