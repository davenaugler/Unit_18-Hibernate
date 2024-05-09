package com.coderscampus.Unit_18_Hibernate.repository;

import com.coderscampus.Unit_18_Hibernate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.List;

//                                                 entity , data type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*
    Creating a method inside an interface. When you do this you provide
       the method signature without the implementation body.
    Means that you specify the method name, return type, and parameters, but you don't write the
       actual code that defines the behavior of the method.
    In an interface, methods are implicitly abstract, which means they don't have an implementation.
       The purpose of an interface is to define a contract or a set of methods that classes must implement.
     */

    List<User> findByUserId(Long userId);

    // SELECT * FROM users WHERE username = :username
    List<User> findByUsername(String username);

    // SELECT * FROM users WHERE name =:name
    List<User> findByName(String name);

    // Find by username and name
    // SELECT * FROM users WHERE username = :username and name = :name
    List<User> findByUsernameAndName(String username, String name);

    List<User> findByCreatedDateBetween(LocalDateTime date1, LocalDateTime date2);

    // Trevors
    // JPQL = Java Persistence Query Language
    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findExactlyOneUserByUsername(String username);

    // Mine
//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    User findExactlyOneUserByUsername(String username);

//    @Query("SELECT * FROM users WHERE name LIKE %?1%")
//    List <User> findUserByNameLike(String name);

//    @Query("SELECT * FROM users WHERE name LIKE %?1%")
//    List<User> findUserByNameLike(String name);

//    @Query("SELECT * FROM users WHERE name LIKE CONCAT('%', ?1, '%')")
//    List<User> findUserByNameLike(String name);





}
