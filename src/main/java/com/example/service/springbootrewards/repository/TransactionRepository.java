package com.example.service.springbootrewards.repository;

import com.example.service.springbootrewards.entity.MyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<MyTransaction, Long> {
}
