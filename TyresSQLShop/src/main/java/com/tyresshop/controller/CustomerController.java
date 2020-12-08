package com.tyresshop.controller;

import com.tyresshop.entity.Customer;
import com.tyresshop.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public CustomerController() throws IOException {
    }


    @RequestMapping("/login")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginForm.html");
        return modelAndView;
    }

    @RequestMapping("/registration")
    ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm.html");
        return modelAndView;
    }

    @PostMapping("/login")
    String login(@RequestParam String name,
                 @RequestParam String password) throws SQLException {

        return customerService.login(name,password);
    }

    @PostMapping("/registration")
    String registration(@RequestParam String name,
                        @RequestParam String phone, @RequestParam String password) throws IOException, SQLException {

        Customer customer = new Customer(name, phone, password, 0);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setPassword(password);
        return customerService.registration(customer);
    }

}

