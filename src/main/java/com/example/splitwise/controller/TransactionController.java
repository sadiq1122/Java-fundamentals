package com.example.splitwise.controller;


import com.example.splitwise.entity.Transaction;
import com.example.splitwise.models.TransactionDTO;
import com.example.splitwise.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    private String gString = "global";

    private TransactionRepository transactionRepository;

    TransactionController(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        // t1, t2
        // 1. code share
        // 2. stack list.add
        System.out.println("Previous value " +  gString);
        gString = Thread.currentThread().getName();
        System.out.println(gString);
        List<Transaction> all = this.transactionRepository.findAll();

        return ResponseEntity.ok(all);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid TransactionDTO t){
        t.setCreatedAt(new Date());
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(t, transaction);
        Transaction save = transactionRepository.save(transaction);
        return ResponseEntity.ok(save);
    }
}
