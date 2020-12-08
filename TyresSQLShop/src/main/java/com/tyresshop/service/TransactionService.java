package com.tyresshop.service;

import com.tyresshop.entity.Transaction;
import java.util.List;

public interface TransactionService {


    List<Transaction> getAll();

    Transaction getById(Integer id);



}
