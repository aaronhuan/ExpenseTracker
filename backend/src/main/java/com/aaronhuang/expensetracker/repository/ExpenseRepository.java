package com.aaronhuang.expensetracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronhuang.expensetracker.model.Expense;
import com.aaronhuang.expensetracker.model.Income;
import com.aaronhuang.expensetracker.model.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);

    Optional<Expense> findByIdAndUser(Long id, User user);
}
