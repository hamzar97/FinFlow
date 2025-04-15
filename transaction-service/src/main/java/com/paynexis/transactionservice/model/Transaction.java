package com.paynexis.transactionservice.model;

import com.paynexis.transactionservice.enums.TransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "transaction")
@Data
public class Transaction {

    @Id
    private String id;
    private String userId;
    private Double amount;
    private Date transactionDate;
    private String category;
    private String description;
    private TransactionType transactionType;
    private Date createdAt;
    private Date updatedAt;
}
