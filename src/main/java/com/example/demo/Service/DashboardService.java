package com.example.demo.Service;
import com.example.demo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Transaction;
import com.example.demo.Model.Type;


import java.util.*;

@Service
public class DashboardService {

    @Autowired
    private TransactionRepository repo;

    public Map<String, Object> getSummary() {
        List<Transaction> list = repo.findAll();

        double income = 0, expense = 0;

        for (Transaction t : list) {
            if (t.getType() == Type.INCOME) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("totalIncome", income);
        map.put("totalExpense", expense);
        map.put("netBalance", income - expense);

        return map;
    }
}