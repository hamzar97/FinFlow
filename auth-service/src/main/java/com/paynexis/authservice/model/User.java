package com.paynexis.authservice.model;

import com.paynexis.authservice.enums.UserRole;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document (collection = "Users")
@Data
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role;
    private Date createdAt;
    private Date updatedAt;

}
