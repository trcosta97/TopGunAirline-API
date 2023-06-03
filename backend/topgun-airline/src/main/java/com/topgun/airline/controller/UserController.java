package com.topgun.airline.controller;


import com.topgun.airline.domain.user.User;
import com.topgun.airline.domain.user.UserSaveDTO;
import com.topgun.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody UserSaveDTO data){
        var savedUser = new User(data);
        userService.saveUser(savedUser);
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

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@RequestBody UserSaveDTO data, @RequestParam Long id){
        var user = new User(data);
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<User> delete(@RequestParam Long id){
        userService.deleteUser(id);
        User deactivatedUser = userService.findUserById(id);
        return ResponseEntity.ok(deactivatedUser);
    }
}
