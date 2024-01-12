package com.example.New_project.controller;


import com.example.New_project.model.User;
import com.example.New_project.service.UserServices;
import jakarta.validation.Valid;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @Cacheable("addUsers")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userServices.getAllUsers().getBody(), HttpStatus.OK);
    }
    @CacheEvict(value = "addUsers", allEntries = true)
    @PostMapping("/addUsers")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userServices.addUsers(user).getBody());
    }
    @PostMapping("/allUsers")
    public ResponseEntity<Map<String,Boolean>> saveAllUsers ( @RequestBody List<User> user){
        return new ResponseEntity<>(userServices.saveAll(user),HttpStatus.CREATED);
    }
    @GetMapping("/users/email/{email}")
    public List<User> findUserByEmail(@PathVariable String email ){
        return userServices.findUserByEmail(email);
    }
    @GetMapping("/users/name/{fullName}")
    public List<User> findUserByFullName(@PathVariable String fullName ){
        return userServices.findUserByFullName(fullName);
    }
    @CacheEvict(value ="Users", allEntries = true)
    @DeleteMapping("/users/{id}")
public ResponseEntity<User> deleteUser (@PathVariable long id){
        return ResponseEntity.ok(userServices.deleteUser(id));
    }
    @CacheEvict(value ="users", allEntries = true)
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUsers (@PathVariable long id, @RequestBody User user){
        return ResponseEntity.ok(userServices.updateUsers(id, user));
    }
}
