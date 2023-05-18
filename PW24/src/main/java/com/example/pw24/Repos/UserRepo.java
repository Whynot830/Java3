package com.example.pw24.Repos;

import com.example.pw24.Tables.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
