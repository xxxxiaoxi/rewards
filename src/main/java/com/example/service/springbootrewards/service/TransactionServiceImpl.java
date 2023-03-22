package com.example.service.springbootrewards.service;

import com.example.service.springbootrewards.entity.Customer;
import com.example.service.springbootrewards.entity.MyTransaction;
import com.example.service.springbootrewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    public MyTransaction saveTransaction(MyTransaction myTransaction) {
        transactionRepository.save(myTransaction);
        return myTransaction;
    }

    public void deleteTransactionById(long id) {
        transactionRepository.deleteById(id);
    }

    public MyTransaction findById(long id) {
        MyTransaction myTransaction = transactionRepository.findById(id).orElse(null);
        return myTransaction;
    }

    public List<MyTransaction> findAllTransactions() {
        List<MyTransaction> transactions = transactionRepository.findAll();
        return transactions;
    }

    public MyTransaction updateTransaction(MyTransaction myTransaction) {
        MyTransaction transaction = transactionRepository.saveAndFlush(myTransaction);
        return transaction;
    }
}
