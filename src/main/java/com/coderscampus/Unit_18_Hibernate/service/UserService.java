package com.coderscampus.Unit_18_Hibernate.service;

import com.coderscampus.Unit_18_Hibernate.domain.User;
import org.springframework.stereotype.Service;
import com.coderscampus.Unit_18_Hibernate.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // Build a method that returns all users
    public Set<User> findAll() {
        return userRepo.findAllUsersWithAccountsAndAddresses();
    }

    public User findById(Long userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.orElse(new User());
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void delete(Long userId) {
        userRepo.deleteById(userId);
    }

    public List<User> findByUserId(Long userId) {
        return userRepo.findByUserId(userId);
    }

    // SELECT * FROM users WHERE username = :username
    public List<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // SELECT * FROM users WHERE name =:name
    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    public List<User> findByUsernameAndName(String username, String name) {
        return userRepo.findByUsernameAndName(username, name);
    }

    public List<User> findByCreatedDateBetween(LocalDateTime date1, LocalDateTime date2) {
        return userRepo.findByCreatedDateBetween(date1, date2);
    }

    public User findExactlyOneUserByUsername(String username) {
        List<User> users = userRepo.findExactlyOneUserByUsername(username);
        if (users.size() > 0)
            return users.get(0);
        else
            return new User();
    }

//    public List<User> findUserByNameLike(String name) {
//        return userRepo.findUserByNameLike(name);
//    }

}