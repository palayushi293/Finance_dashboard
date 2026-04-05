package com.example.demo.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "transactions")
@Data
public  class Transaction {

    @Id
    private String id;

    private double amount;
    private Type type;  

    private String category;
    private LocalDate date;
    private String description;
	public Type getType() {
	
		return type;
	}
	public double getAmount() {
		
		return amount;
	}
	public void setId(String id2) {
		// TODO Auto-generated method stub
		
	}
}
