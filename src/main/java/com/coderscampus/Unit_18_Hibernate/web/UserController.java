package com.coderscampus.Unit_18_Hibernate.web;

import com.coderscampus.Unit_18_Hibernate.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.coderscampus.Unit_18_Hibernate.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.put("users", users);
        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getOneUser(ModelMap model, @PathVariable Long userId) {
        User user = userService.findById(userId);
        model.put("users", Arrays.asList(user));
        return "users";
    }
}
