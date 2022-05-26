package com.example.spring_springboot.spring_rest.service;

import com.example.spring_springboot.spring_rest.dao.UserDao;
import com.example.spring_springboot.spring_rest.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {this.userDao = userDao;}

    @Override
    public User add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }
    //orElseThrow - это метод, который возвращает значение, если оно присутствует, в противном случае вызывает исключение.
    @Override
    public User update(User user, Long id) {
        User anotherUser = userDao.findById(id).orElseThrow(
                ()-> new RuntimeException("Пользователь не найден"));
        anotherUser.setName(user.getName());
        anotherUser.setSurname(user.getSurname());
        anotherUser.setAge(user.getAge());
        anotherUser.setEmail(user.getEmail());
        anotherUser.setRoles(user.getRoles());
        return userDao.save(anotherUser);
    }

    @Override
    public void delete(Long id) {
        User anotherUser = userDao.findById(id).orElseThrow(
                ()-> new RuntimeException("Пользователь не найден"));
        userDao.delete(anotherUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.findById(id).orElseThrow(
                ()-> new RuntimeException("Пользователь с таким id не найден"));
    }

    @Override
    public User findByUsername(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь с email = '%s' не найден"));
        }
        return user;
    }
}
