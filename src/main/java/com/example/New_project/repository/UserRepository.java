package com.example.New_project.repository;

import com.example.New_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

   List <User> findUserByFullName(String fullName);
   List <User> findUserByEmail(String email);
}
