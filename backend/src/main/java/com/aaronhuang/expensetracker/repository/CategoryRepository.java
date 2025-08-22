package com.aaronhuang.expensetracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronhuang.expensetracker.model.Category;
import com.aaronhuang.expensetracker.model.Expense;
import com.aaronhuang.expensetracker.model.User;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    List<Category> findByUser(User user);

    Optional<Category> findByIdAndUser(Long id, User user);
}
