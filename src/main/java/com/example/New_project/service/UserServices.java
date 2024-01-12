package com.example.New_project.service;

import com.example.New_project.exception.BookNotFoundException;
import com.example.New_project.model.User;

import com.example.New_project.repository.UserRepository;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/addUsers")
    public ResponseEntity<User> addUsers (@Valid User user){
        return ResponseEntity.ok( userRepository.save(user));
    }
    public Map<String, Boolean> saveAll (List<User> user){
        Map<String, Boolean> response = new HashMap<>();
        for (User users : user)
            response.put(users.getFullName() + "posted successfully", true);
        userRepository.saveAll(user);
        return response;
    }

    public ResponseEntity <List<User>> getAllUsers (){

        return ResponseEntity.ok(userRepository.findAll());
    }

    public User findUserById (long id){
        return userRepository.findById(id).orElseThrow(()-> new  BookNotFoundException("book not found"));
    }

    public List<User> findUserByFullName (String fullName){
        return userRepository.findUserByFullName(fullName);
    }
    public List<User> findUserByEmail (String email){
        return userRepository.findUserByEmail(email);
    }
    public String updateUsers (long id, User libraryUser){
        User user = findUserById(id);
        user.setFullName(libraryUser.getFullName());
        user.setEmail(libraryUser.getEmail());
        user.setAge(libraryUser.getAge());
        user.setAddress(libraryUser.getAddress());

        userRepository.save(user);
        return "saved successfully";
    }

    public User deleteUser (long id){
        User user = findUserById(id);
        userRepository.delete(user);
        return user;
    }
}
