package com.tyresshopjdbc.service;

import com.tyresshopjdbc.dao.CustomerDao;
import com.tyresshopjdbc.dao.impl.CustomerDaoImpl;
import com.tyresshopjdbc.entity.Customer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    public CustomerServiceImpl() throws IOException {
    }


    @Override
    public String login(String name, String password) throws SQLException {
        Customer findCustomer = customerDao.findByName(name);
        if (password == null) {
            return "no password entered!";
        }
        if (findCustomer != null) {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (password.equals(findCustomer.getPassword())) {
                return "OK! Customer ID is: " + customerDao.getIdByName(name);
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

        return "This login is not available!";

    }

    @Override
    public String deleteCustomer(String name) throws IOException, SQLException {

        if (customerDao.findByName(name) != null) {
            customerDao.deleteCustomer(name);
            return "Fine!";
        }

        return "false";

    }

    @Override
    public String editCustomer(int id, String name, String phone, String password, int discount) throws IOException, SQLException {
        Customer eCustomer = customerDao.findById(id);
        if (eCustomer != null) {
            customerDao.editCustomer(id, name, phone, password, discount);
            return "Fine!";
        }

        return "This login is not available!";

    }

    @Override
    public String getAllCustomers() throws SQLException, IOException {
        String result = "";
        CustomerDao customerDao = new CustomerDaoImpl();
        List<Customer> customerList = customerDao.getAll();
        for(Customer customer: customerList) {

            result += " customer ID: ";
            result += customer.getId() + " name: "
                    + customer.getName() + " phone: "
                    + customer.getPhone() + " discount: "
                    + customer.getDiscount();
        }

        return result;
    }
}
