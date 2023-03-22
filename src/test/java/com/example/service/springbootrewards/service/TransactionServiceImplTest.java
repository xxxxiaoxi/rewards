package com.example.service.springbootrewards.service;

import com.example.service.springbootrewards.SpringBootRewardsApplication;
import com.example.service.springbootrewards.entity.MyTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRewardsApplication.class)
public class TransactionServiceImplTest {
    @Resource
    private TransactionServiceImpl transactionService;

    @Test
    public void saveTransaction() {
        MyTransaction myTransaction = transactionService.findById(1);
        transactionService.saveTransaction(myTransaction);
    }

    @Test
    public void deleteTransactionById() {
        transactionService.deleteTransactionById(1);
    }

    @Test
    public void findById() {
        transactionService.findById(1);
    }

    @Test
    public void findAllTransactions() {
        transactionService.findAllTransactions();
    }

    @Test
    public void updateTransaction() {
        MyTransaction curTransaction = transactionService.findById(2);
        MyTransaction transaction = transactionService.findById(3);
        curTransaction.setCustomer(transaction.getCustomer());
        curTransaction.setDescription(transaction.getDescription());
        curTransaction.setId(transaction.getId());
        curTransaction.setSaveDate(transaction.getSaveDate());
        curTransaction.setTotal(transaction.getTotal());
        transactionService.updateTransaction(curTransaction);
    }
}