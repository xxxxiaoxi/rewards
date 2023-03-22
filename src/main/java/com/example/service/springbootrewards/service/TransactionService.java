package com.example.service.springbootrewards.service;

import com.example.service.springbootrewards.entity.MyTransaction;

import java.util.List;

public interface TransactionService {
    MyTransaction saveTransaction(MyTransaction transaction);
    void deleteTransactionById(long id);
    MyTransaction findById(long id);
    List<MyTransaction> findAllTransactions();
    MyTransaction updateTransaction(MyTransaction myTransaction);
}
