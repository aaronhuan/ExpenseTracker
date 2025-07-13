package com.aaronhuang.expensetracker.service;

import java.util.Optional;
import java.util.List;

import com.aaronhuang.expensetracker.model.User;

public interface UserService {
    User create(User u);
    Optional<User> getById(Long id);
    List<User> getAll();
    User updateById(Long id, User u);
    User deleteById(Long id);
}
