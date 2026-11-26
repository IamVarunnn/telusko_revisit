package com.varun.SpringBootRestJobApp_1.repository;

import com.varun.SpringBootRestJobApp_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}