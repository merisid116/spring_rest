package com.example.spring_springboot.spring_rest.dao;

import com.example.spring_springboot.spring_rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User getUserByEmail(String username);
}

