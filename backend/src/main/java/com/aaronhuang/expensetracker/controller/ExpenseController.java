package com.aaronhuang.expensetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceImpl uSvc;

    public UserController(UserServiceImpl uSvc){
        this.uSvc = uSvc;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional <User> user = uSvc.getById(id);
        return ResponseEntity.of(user); 
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(uSvc.getAll());
    }   

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User u) {
        User created = uSvc.create(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User u) {
        User updated = uSvc.updateById(id,u);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User deleted = uSvc.deleteById(id);
        return ResponseEntity.ok(deleted);
    }
    
}