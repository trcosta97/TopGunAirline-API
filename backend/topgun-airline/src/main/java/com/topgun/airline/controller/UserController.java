package com.topgun.airline.controller;


import com.topgun.airline.domain.user.User;
import com.topgun.airline.domain.user.UserDTO;
import com.topgun.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Transactional
    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody UserDTO data){
        var newUser = new User(data);
        User savedUser = userService.saveUser(newUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@RequestParam Long id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> allUsers = userService.findAllUsers();
        return ResponseEntity.ok(allUsers);
    }
    @Transactional
    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO data, @RequestParam Long id){
        var user = new User(data);
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<User> delete(@RequestParam Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
