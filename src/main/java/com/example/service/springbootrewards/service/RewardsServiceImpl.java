package com.example.service.springbootrewards.service;

import java.util.List;

import com.example.service.springbootrewards.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.service.springbootrewards.entity.Customer;

@Service
public class RewardsServiceImpl implements RewardsService{
	
	@Autowired
	private CustomerRepository customerRepository;

//	@Async
	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}
//	@Async
	@Cacheable("customers")
	public Customer getCustomerById(Integer customerId) {
		simulateSlowService();
		return customerRepository.findById(customerId).orElse(null);
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	public Customer saveCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
//	public ResponseEntity<Customer> getCustomerById(Integer customerId) {
//		Customer customer = customerRepository.findById(customerId).orElse(null);
//		return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
//	}

}
