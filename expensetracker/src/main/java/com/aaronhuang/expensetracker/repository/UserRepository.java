package com.aaronhuang.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronhuang.expensetracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
