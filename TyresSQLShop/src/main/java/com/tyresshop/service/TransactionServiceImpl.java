package com.tyresshop.service;

import com.tyresshop.dao.TransactionDao;
import com.tyresshop.dao.impl.TransactionDaoImpl;
import com.tyresshop.entity.Transaction;
import com.tyresshop.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;

        try {
            this.transactionDao = new TransactionDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getById(Integer id) {
        return transactionRepository.findById(id).get();
    }


}
