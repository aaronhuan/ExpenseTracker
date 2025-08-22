package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaronhuang.expensetracker.model.Income;
import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.repository.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository repo;
    private final UserServiceImpl userService;

    public IncomeServiceImpl(IncomeRepository repo, UserServiceImpl userService) {
        this.repo = repo;
        this.userService = userService;
    }
    @Override
    public Income create(Income income, String authHeader) {
        User user= userService.getUserFromToken(authHeader);
        income.setUser(user);
        return repo.save(income);
    }

    @Override
    public Optional<Income> getById(Long id, String authHeader) {
        User user = userService.getUserFromToken(authHeader);
        return repo.findByIdAndUser(id,user);
    }

    @Override
    public List<Income> getAll(String authHeader) {
        User user = userService.getUserFromToken(authHeader);
        return repo.findByUser(user);
    }

    @Override
    public Income updateById(Long id, Income income, String authHeader) {
        User user = userService.getUserFromToken(authHeader);
        Income existing = repo.findByIdAndUser(id, user)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Income not Found: " + id));
        existing.setAmount(income.getAmount());
        existing.setSource(income.getSource());
        existing.setReoccuring(income.getReoccuring());
        existing.setFrequency(income.getFrequency());
        //don't change user
        return repo.save(existing);
    }

    @Override
    public Income deleteById(Long id, String authHeader) {
        User user = userService.getUserFromToken(authHeader);
        Income existing = repo.findByIdAndUser(id, user)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Income not Found: " + id));
        repo.delete(existing);
        return existing;
    }
}