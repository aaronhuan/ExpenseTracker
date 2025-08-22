package com.aaronhuang.expensetracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronhuang.expensetracker.model.Income;
import com.aaronhuang.expensetracker.model.User;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUser(User user);

    Optional<Income> findByIdAndUser(Long id, User user);
}
