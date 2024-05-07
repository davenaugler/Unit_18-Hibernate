package com.coderscampus.Unit_18_Hibernate.domain;

import com.coderscampus.Unit_18_Hibernate.util.DateTimeUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// @Entity annotation is placed above the Class name to indicate the class is an entity
//         and should be mapped to a database table.
@Entity // By default...Class name = User, DB Table name = user
// @Table - @Table annotation, if your table is called something other than the Class name below, user,
//          then you need to use '@Table(name="database_name_here")' to identify what the
//          table name is. In this case 'user' is a pre-defined name and not usable.
@Table(name="users")
public class User {
    private Long userId;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createdDate;
    // For ManyToMany relationship with Account
    private List<Account> accounts = new ArrayList<>();
    private Address address;


    // @Id - Using @Id annotation tells the SQL Table what the Primary Key is.
    //       We know the Primary Key is getUserId but Hibernate doesn't intuitively know.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  This strategy relies on the database's identity column feature to generate
    //      the primary key values. It indicates that the database should automatically
    //      generate the primary key values using an identity column
    //      (e.g., AUTO_INCREMENT in MySQL, IDENTITY in SQL Server).

    // When you use GenerationType.IDENTITY, the persistence provider will not
    //     generate the primary key values itself. Instead, it will delegate the
    //     responsibility to the database. The database will automatically assign
    //     a unique value to the primary key column whenever a new record is inserted into the table.

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "created_date")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    // ------------------------
    // What's happening below?
    // 1. Assign a ManyToMany annotation
    // 2. Map the 'JoinTable' out on the owning side/parent side.
    // 3. Specify the name of the 'JoinTable', which is 'user_account'
    //      We decided to name it 'user_account' because that just makes sense here
    // 4. Specify the JoinColumn on the parent side, which is 'user_id'
    // 5. Specify the InverseJoinColumn on the child side, which is 'account_id'
    // 6. Map this on the getter
    // 7. Go do something similar to the child class, in this case, 'Account'
    // ------------------------
    @ManyToMany
    @JoinTable(name="user_account",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="account_id"))
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @OneToOne(mappedBy = "user")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + (createdDate != null ? DateTimeUtil.formatDateTimeToZone(createdDate, null) : "null") + // Using the utility method with the system's default time zone
                ", accounts=" + accounts +
                ", address=" + address +
                '}';
    }
}
