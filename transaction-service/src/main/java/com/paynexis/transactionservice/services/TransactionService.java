package com.paynexis.transactionservice.services;

import com.paynexis.transactionservice.model.Transaction;
import com.paynexis.transactionservice.repository.TransactionRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(String id) {
            return transactionRepository.findById(id).get();
    }
    public Transaction getTransactionByUserId(String userId) { return transactionRepository.findByUserId(userId); }
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public void deleteTransactionByTransactionId(String transactionId) {
        transactionRepository.deleteById(transactionId);
    }
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
