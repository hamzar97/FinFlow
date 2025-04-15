package com.paynexis.budgetservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "budget")
@Data
public class Budget {
    @Id
    private String id;
    private String userId;
    private Category category;
    private Double limit;
    private Double currentSpend;
    private Date createdAt;
    private Date updatedAt;
}
