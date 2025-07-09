package com.aaronhuang.expensetracker.service;

import org.springframework.stereotype.Service;

import com.aaronhuang.expensetracker.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepo;
}
