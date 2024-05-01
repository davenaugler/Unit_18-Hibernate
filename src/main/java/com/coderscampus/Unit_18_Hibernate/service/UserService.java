package com.coderscampus.Unit_18_Hibernate.service;

import com.coderscampus.Unit_18_Hibernate.domain.User;
import org.springframework.stereotype.Service;
import com.coderscampus.Unit_18_Hibernate.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // Build a method that returns all users
    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.orElse(new User());
    }

    public User createUser(User user) {
        return userRepo.save(user);

    }
}