package com.cf.controller;

import com.cf.model.User;
import com.cf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
