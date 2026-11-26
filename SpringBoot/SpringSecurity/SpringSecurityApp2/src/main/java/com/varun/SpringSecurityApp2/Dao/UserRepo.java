package com.varun.SpringSecurityApp2.Dao;

import com.varun.SpringSecurityApp2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
