package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repo;
    public UserServiceImpl(UserRepository repo){
        this.repo=repo;
    }

    @Override
    public User create(User u){
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
}