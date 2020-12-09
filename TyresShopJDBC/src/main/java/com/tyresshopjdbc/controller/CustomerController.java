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
@RequestMapping("/customer")
public class CustomerController {

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public CustomerController() throws IOException {
    }

    @RequestMapping("/login")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginform.html");

        return modelAndView;
    }

    @RequestMapping("/reg")
    ModelAndView regForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("regform.html");

        return modelAndView;
    }

    @PostMapping("/login")
    String login(@RequestParam String name,
                 @RequestParam String password) throws SQLException {

        return customerService.login(name, password);
    }

    @PostMapping("/reg")
    String registration(@RequestParam String name,
                        @RequestParam String phone,
                        @RequestParam String password,
                        @RequestParam int discount) throws IOException, SQLException {

        Customer customer = new Customer(name, phone, password, discount);

        customer.setName(name);
        customer.setPhone(phone);
        customer.setPassword(password);
        customer.setDiscount(discount);

        return customerService.registration(customer);

    }

}
