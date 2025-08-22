package com.aaronhuang.expensetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaronhuang.expensetracker.dto.LoginRequest;
import com.aaronhuang.expensetracker.dto.LoginResponse;
import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(uSvc.getAll());
    }   

    @PostMapping("/register")
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
    
    // @PostMapping("/login")
    // public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginRequest loginRequest) {
    //     User user = uSvc.findByEmail(loginRequest.getEmail());
    //     if (user == null || !passwordEncoder().matches(loginRequest.getPassword(), user.getPassword())) {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //     }

    //     String token = jwtTokenUtil.generateToken(user);
    //     response.put("user", user);
    //     response.put("token", token);

    //     return ResponseEntity.ok(response);
    // }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        try{
            LoginResponse response= uSvc.verify(loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
  
}