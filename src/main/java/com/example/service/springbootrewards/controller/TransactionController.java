package com.example.service.springbootrewards.controller;

import com.example.service.springbootrewards.entity.MyTransaction;
import com.example.service.springbootrewards.exception.TransactionNotFoundException;
import com.example.service.springbootrewards.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping("/transactions")
    public List<MyTransaction> findTransactionAll() {
        return transactionService.findAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<MyTransaction> getTransaction(@PathVariable("id") Long id) {
        MyTransaction myTransaction = transactionService.findById(id);
        if (myTransaction == null) {
            throw new TransactionNotFoundException("Transaction doesn't exist");
        }
        return new ResponseEntity<MyTransaction>(myTransaction, HttpStatus.OK);
    }

    @PostMapping("/transactions/create")
    public ResponseEntity<MyTransaction> createTransaction(@Validated @RequestBody MyTransaction transaction) {
        MyTransaction savedTransaction = transactionService.saveTransaction(transaction);
        return new ResponseEntity<MyTransaction>(transaction, HttpStatus.OK);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<MyTransaction> deleteStudent(@PathVariable("id") long id) {
        MyTransaction myTransaction = transactionService.findById(id);
        if (myTransaction == null) {
            throw new TransactionNotFoundException("Transaction doesn't exist");
        }
        transactionService.deleteTransactionById(id);
        return new ResponseEntity<MyTransaction>(myTransaction, HttpStatus.OK);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<MyTransaction> updateTransaction(@PathVariable("id") long id, @RequestBody MyTransaction transaction) {
        MyTransaction curTransaction = transactionService.findById(id);
        if (curTransaction == null) {
            throw new TransactionNotFoundException("Transaction doesn't exist");
        }
        curTransaction.setCustomer(transaction.getCustomer());
        curTransaction.setDescription(transaction.getDescription());
        curTransaction.setId(transaction.getId());
        curTransaction.setSaveDate(transaction.getSaveDate());
        curTransaction.setTotal(transaction.getTotal());
        transactionService.updateTransaction(curTransaction);
        return new ResponseEntity<>(curTransaction, HttpStatus.OK);
    }
}
