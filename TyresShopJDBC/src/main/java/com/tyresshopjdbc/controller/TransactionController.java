package com.tyresshopjdbc.controller;

import com.tyresshopjdbc.service.TransactionService;
import com.tyresshopjdbc.service.TransactionServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class TransactionController {

    TransactionService transactionService = new TransactionServiceImpl();


    public TransactionController() throws IOException {
    }

    @RequestMapping("/transactionid")
    ModelAndView findTransactionForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transactionid.html");

        return modelAndView;
    }

    @PostMapping("/transactionid")
    String getTransactionById (@RequestParam int id) throws SQLException {

        return transactionService.findTransactionById(id);

    }
}
