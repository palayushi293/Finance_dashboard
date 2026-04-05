package com.example.demo.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}