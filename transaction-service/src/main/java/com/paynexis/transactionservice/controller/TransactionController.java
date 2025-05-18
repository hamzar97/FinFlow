package com.paynexis.transactionservice.controller;

import com.paynexis.transactionservice.model.Transaction;
import com.paynexis.transactionservice.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    @GetMapping(path = "/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable String transactionId) {
        return new ResponseEntity<>(transactionService.getTransactionById(transactionId), HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<Transaction> getTransactionByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(transactionService.getTransactionByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }
    @PutMapping(path = "/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable String transactionId) {
        transaction.setId(transactionId);
        return new ResponseEntity<>(transactionService.updateTransaction(transaction), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{transactionId}")
    public ResponseEntity deleteTransactionByTransactionId(@PathVariable String transactionId) {
        transactionService.deleteTransactionByTransactionId(transactionId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
