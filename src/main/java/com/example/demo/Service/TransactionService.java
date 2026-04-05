package com.example.demo.Service;

import com.example.demo.Model.Transaction;
import com.example.demo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    // ✅ ADD THIS METHOD
    public Transaction add(Transaction t) {
        return repo.save(t);
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}