package com.tyresshopjdbc.controller;

import com.tyresshopjdbc.entity.Customer;
import com.tyresshopjdbc.service.CustomerService;
import com.tyresshopjdbc.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class CustomerController {

    CustomerService customerService = new CustomerServiceImpl();

    public CustomerController() throws IOException {
    }

    @RequestMapping("/login")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginform.html");

        return modelAndView;
    }

    @PostMapping("/login")
    String login(@RequestParam String name,
                 @RequestParam String password) throws SQLException {

        return customerService.login(name, password);
    }

    @RequestMapping("/registration")
    ModelAndView regForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("regform.html");

        return modelAndView;
    }

    @PostMapping("/registration")
    String registration(@RequestParam String name,
                        @RequestParam String phone,
                        @RequestParam String password,
                        @RequestParam int discount) throws IOException, SQLException {

        Customer customer = new Customer();

        customer.setName(name);
        customer.setPhone(phone);
        customer.setPassword(password);
        customer.setDiscount(discount);

        return customerService.registration(customer);

    }

    @RequestMapping("/delcustomer")
    ModelAndView delForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delcustomer.html");

        return modelAndView;
    }

    @PostMapping("/delcustomer")
    String deleteCustomer(@RequestParam String name) throws SQLException, IOException {

        return customerService.deleteCustomer(name);

    }

    @RequestMapping("/editcustomer")
    ModelAndView editCustomerForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editcustomer.html");

        return modelAndView;
    }

    @PostMapping("/editcustomer")
    String editCustomer(@RequestParam int id,
                        @RequestParam String name,
                        @RequestParam String phone,
                        @RequestParam String password,
                        @RequestParam int discount) throws SQLException, IOException {

        return customerService.editCustomer(id, name, phone, password, discount);

    }

    @RequestMapping("/allcustomers")
    ModelAndView allCustomersForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allcustomers.html");

        return modelAndView;
    }

    @PostMapping("/allcustomers")
    String allCustomers() throws SQLException, IOException {

        return customerService.getAllCustomers();
    }

}
