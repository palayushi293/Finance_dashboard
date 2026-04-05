package com.example.demo.Controller;

import com.example.demo.Model.Transaction;
import com.example.demo.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.Type;
import java.util.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private TransactionService service;

    @GetMapping("/summary")
    public String summary() {

        List<Transaction> list = service.getAll();

        double income = 0, expense = 0;

        for (Transaction t : list) {
            if (t.getType()==Type.INCOME)
                income += t.getAmount();
            else
                expense += t.getAmount();
        }

        return "Income: " + income +
               " Expense: " + expense +
               " Balance: " + (income - expense);
    }
}