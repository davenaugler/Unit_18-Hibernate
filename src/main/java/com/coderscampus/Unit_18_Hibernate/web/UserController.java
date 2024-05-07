package com.coderscampus.Unit_18_Hibernate.web;

import com.coderscampus.Unit_18_Hibernate.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.coderscampus.Unit_18_Hibernate.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("pageTitle", "Users");
        return "users";
    }

//    @GetMapping("/users")
//    public String getAllUsers(ModelMap model) {
//        List<User> users = userService.findByUsername("DaveN");
//        model.put("users", users);
//        model.addAttribute("pageTitle", "Users");
//        if(users.size() == 1) {
//            // This could throw an IndexOutOfBounds Exception if there
//            // is no first element. Because we have a users.size check on size
//            // prior to grabbing the first element, we are fine.
//            model.put("user", users.get(0));
//        }
//        return "users";
//    }

//    @GetMapping("/users")
//    public String getAllUsers(ModelMap model) {
////        List<User> users = userService.findByUsername("trevor@craftycodr.com");
//        List<User> users = userService.findByUsernameAndName("trevor@craftycodr.com", "Trevor Page2");
//        model.put("users", users);
//        model.addAttribute("pageTitle", "Users");
//        if(users.size() == 1) {
//            // This could throw an IndexOutOfBounds Exception if there
//            // is no first element. Because we have a users.size check on size
//            // prior to grabbing the first element, we are fine.
//            model.put("user", users.get(0));
//        }
//        return "users";
//    }

    @GetMapping("/users/{userId}")
    public String getOneUser(@PathVariable Long userId, ModelMap model) {
        User user = userService.findById(userId);
        model.put("users", Arrays.asList(user));
        // Code smell, line below
        model.put("user", user);
        return "users";
    }

    @PostMapping("/users/{userId}")
    public String postOneUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/" + user.getUserId();
    }

    @GetMapping("/register")
    public String getCreateUser(ModelMap model) {
        model.put("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postCreateUser(User user) {
        System.out.println("user before: " + user);
        userService.saveUser(user);
        System.out.println("user after: " + user);
        return "redirect:/register";
    }

    @PostMapping("/users/{userId}/delete")
    public String deleteOneUser(@PathVariable Long userId, User user) {
        userService.delete(userId);
        return "redirect:/users";
    }
}
