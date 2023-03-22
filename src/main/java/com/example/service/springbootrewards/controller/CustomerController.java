package com.example.service.springbootrewards.controller;

import java.util.List;

import com.example.service.springbootrewards.exception.CustomerNotFountException;

import com.example.service.springbootrewards.service.RewardsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.service.springbootrewards.entity.Customer;


@RestController
public class CustomerController {

	@Autowired
	private RewardsServiceImpl rewardsServiceImpl;

	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsServiceImpl.getCustomerAll();
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) {
		Customer customer = rewardsServiceImpl.getCustomerById(id);
		if (customer == null) {
			throw new CustomerNotFountException("Customer doesn't exist!");
		}
		long res = customer.getRewardPoints();
		double res1 = customer.getTotalPurchases();
		System.out.println("points:" + res + "purchases:" + res1);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PostMapping("/customers/create")
	public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer) {
		Customer savedCustomer = rewardsServiceImpl.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	
}
