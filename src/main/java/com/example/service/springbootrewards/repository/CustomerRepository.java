package com.example.service.springbootrewards.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.springbootrewards.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
//    @Cacheable("customers")
//    Customer findById(Integer customerId);
}
