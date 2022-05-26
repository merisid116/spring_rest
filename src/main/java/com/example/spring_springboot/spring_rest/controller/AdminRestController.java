package com.example.spring_springboot.spring_rest.controller;

import com.example.spring_springboot.spring_rest.entity.User;
import com.example.spring_springboot.spring_rest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/users")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {this.userService = userService;}

    @GetMapping()
    public List <User> getAll() {
        return userService.getAllUsers();
    }

//    ResponseEntity - специальный класс, который представляет http-ответ.
//    Он содержит тело ответа, код состояния, заголовки.
//    Мы можем использовать его для более тонкой настройки http-ответа.

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById (@PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }//Ярлык для создания ResponseEntity с заданным телом и статусом OK(200).

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<User> editUser (@RequestBody User user, @PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable ("id") Long id) {
        userService.delete(id);
    }



}
