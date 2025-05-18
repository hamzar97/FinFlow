package com.paynexis.transactionservice.controller;

import com.paynexis.transactionservice.model.Transaction;
import com.paynexis.transactionservice.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }
    @PutMapping(path = "/{transactionId}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable String transactionId) {
        transaction.setId(transactionId);
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping(path = "/{transactionId}")
    public void deleteTransaction(@PathVariable String transactionId) {
        transactionService.deleteTransaction(transactionService.getTransactionById(transactionId));
    }

}
