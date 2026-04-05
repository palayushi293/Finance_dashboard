package com.example.demo.Controller;

import com.example.demo.Model.Transaction;
import com.example.demo.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.demo.Model.Role;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

   
    @PostMapping("/add")
    public Object add(@RequestBody Transaction t,
                      @RequestParam Role role) {

        if (role != Role.ADMIN) {
            return "Access Denied  Only ADMIN can add transactions";
        }

        return service.add(t);
    }

    @GetMapping("/all")
    public List<Transaction> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id,
                         @RequestParam Role role) {

        System.out.println("DELETE API  ID: " + id);

        if (role != Role.ADMIN) {
            return "Access Denied ";
        }

        service.delete(id);
        return "Deleted ";
    }
}
