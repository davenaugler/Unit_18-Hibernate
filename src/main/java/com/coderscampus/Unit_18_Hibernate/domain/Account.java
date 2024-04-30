package com.coderscampus.Unit_18_Hibernate.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {
   private Long accountId;
   private String accountName;
   // Relationship: One to Many
   // We will have One 'Account' for each of the 'Transactions'
   // Account = One | Transaction = Many
   // We use a 'List', within the 'Account' Class, to infer that we will have Many transactions
   //   within this one 'Account'
    // 1. Structure is in place.
    // 2. Need to tell Hibernate what this field is. Go to getter and add '@OneToMany()
   private List<Transaction> transactions = new ArrayList<>();
   // For ManyToMany relationship with User
   private List<User> users = new ArrayList<>();

    @Id // Assigns Primary Key to getAccountId()
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Increment the Id/Primary Key
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(length = 100) // Changes the SQL VARCHAR length from 255, to 100 characters
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @OneToMany(mappedBy = "account")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    // ------------------------
    // What's happening below?
    // 1. Assign a ManyToMany annotation
    // 2. Since the parent table, 'User' has the 'JoinTable' you need add 'mappedBy' to the ManyToMany annotation.
    // 3. Ensure that you are using the correct variable name from List in the User class, aka 'accounts'
    // ------------------------
    @ManyToMany(mappedBy = "accounts")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

