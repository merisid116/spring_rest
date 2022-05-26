package com.example.spring_springboot.spring_rest.service;

import com.example.spring_springboot.spring_rest.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
     User add (User user);
     User update (User user, Long id);
     void delete (Long id);
     List<User> getAllUsers();
     User getById (Long id);
     User findByUsername (String username);
}
