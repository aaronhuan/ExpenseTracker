package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder){
        this.repo=repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User u){
        // Hash+Salt the password before saving
        String encryptedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encryptedPassword);
        return repo.save(u);
    }

    @Override
    public Optional<User> getById(Long id){
        return repo.findById(id);
    }

    @Override
    public List<User> getAll(){
        return repo.findAll();
    }

    @Override
    public User updateById(Long id, User u){
        User existing = getById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "User not Found: " + id));
        existing.setName(u.getName());

        //update password only if provided
        if(u.getPassword() != null && !u.getPassword().isEmpty()){
            String encryptedPassword = passwordEncoder.encode(u.getPassword());
            existing.setPassword(encryptedPassword);
        }
        return repo.save(existing);
    }

    @Override
    public User deleteById(Long id){
        User existing = getById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                                            "User not found: " + id));
        repo.delete(existing);
        return existing;
    }

    public boolean authenticateUser(String email, String rawPassword) {
        Optional<User> userOpt = repo.findByEmail(email);
        if (!userOpt.isPresent()) {
            return false; // User not found
        }

        User user = userOpt.get();
        // Check if the raw password matches the stored hashed password
        return passwordEncoder.matches(rawPassword, user.getPassword());
        
    }
}