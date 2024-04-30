package com.coderscampus.Unit_18_Hibernate.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {
    // --------------------------------------
    // NOTES
    //    private Long transactionId;
    // Was going to use 'ZonedDateTime' rather than 'Instant' so that the time can be displayed for the
    //    users specific time zone. Yet that is more overhead than what's needed at this moment.
    // Consider using ZonedDateTime' in the future.
    //   - Ensure SQL database is set up to manage the Time Zone data
    // Kept fighting to use 'Instant' and make the 'Instant' make SQL create a TIMESTAMP vs. DATETIME.
    // I was not able to resolve that. Regressing back to 'LocalDateTime' for now.
    //    private LocalDateTime transactionDate;
    // Was going to use 'BigDecimal' instead of 'Double'
    //    - Next time try using 'BigDecimal' and see what the differences are between it and Double.
    // --------------------------------------

    private Long transactionId;
    private LocalDateTime transactionDate;
    private Double amount;
    private String type;
    // Relationship: Many to One
    // We will have Many 'Transactions' for each 'Account'
    // Account = One | Transaction = Many
    // We will grab the parent, aka 'Account', put it as one of our instance variables
    //   and assign it a @ManyToOne annotation
    private Account account;

    @Id // Assigns Primary Key to getAccountId()
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Increment the Id/Primary Key
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne
    // This is over-riding the name of the default Foreign Key (account_account_id)
    @JoinColumn(name="account_id")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
