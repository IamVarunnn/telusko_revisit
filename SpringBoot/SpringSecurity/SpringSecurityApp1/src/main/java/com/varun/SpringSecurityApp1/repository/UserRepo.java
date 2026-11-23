package com.varun.SpringSecurityApp1.repository;

import com.varun.SpringSecurityApp1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
