package com.example.service.springbootrewards.service;

import com.example.service.springbootrewards.entity.Customer;

import java.util.List;

public interface RewardsService {
    List<Customer> getCustomerAll();

    Customer getCustomerById(Integer customerId);
    Customer saveCustomer(Customer customer);
}
