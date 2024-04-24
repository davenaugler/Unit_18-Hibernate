package domain;

import jakarta.persistence.*;

// @Entity annotation is placed above the Class name to indicate the class is an entity
//         and should be mapped to a database table.
@Entity // By default...Class name = User, DB Table name = user
// @Table - @Table annotation, if your table is called something other than the Class name below, user,
//          then you need to use '@Table(name="database_name_here")' to identify what the
//          table name is. In this case 'user' is a pre-defined name and not usable.
@Table(name="users")
public class User {
    private Long userID;
    private String username;
    private String password;
    private String name;

    // @Id - Using @Id annotation tells the SQL Table what the Primary Key is.
    //       We know the Primary Key is getUserID but Hibernate doesn't intuitively know.
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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
}
