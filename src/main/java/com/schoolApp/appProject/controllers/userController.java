package com.schoolApp.appProject.controllers;

import com.schoolApp.appProject.entities.user;
import com.schoolApp.appProject.repos.userRepository;

import com.schoolApp.appProject.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class userController {
    private userService userService;
    public userController(userRepository userService){
        this.userService= (com.schoolApp.appProject.services.userService) userService;
    }
    @GetMapping
    public List<user> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public user createUser(@RequestBody user newUser){
        return userService.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public user getOneUser(@PathVariable Long userId){
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public user updateOneUser(@PathVariable Long userId, @RequestBody user newUser){
       return userService.updateOneUser(userId,newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }


}
