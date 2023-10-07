package com.schoolApp.appProject.services;

import com.schoolApp.appProject.entities.user;
import com.schoolApp.appProject.repos.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    userRepository userRepository;

    public userService(com.schoolApp.appProject.repos.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public user saveOneUser(user newUser) {
        return userRepository.save(newUser);
    }

    public user getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public user updateOneUser(Long userId, user newUser) {
        Optional<user> user= userRepository.findById(userId);
        if(user.isPresent()){
            user foundUser=user.get();
            foundUser.setNameSurname(newUser.getNameSurname());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setAdress(newUser.getAdress());
            foundUser.setTitle(newUser.getTitle());
            foundUser.setPhone(newUser.getPhone());
            userRepository.save(foundUser);
            return foundUser;

        }else
            return null;
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
