package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaronhuang.expensetracker.model.Expense;
import com.aaronhuang.expensetracker.model.User;
import com.aaronhuang.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository repo;
    private final UserServiceImpl userService;
    public ExpenseServiceImpl(ExpenseRepository repo, UserServiceImpl userService){
        this.repo = repo;
        this.userService = userService;
    }

    @Override 
    public Expense create(Expense e, String authHeader){
        User user= userService.getUserFromToken(authHeader);
        e.setUser(user);
        return repo.save(e);
    }


    @Override
    public Optional<Expense> getById(Long id, String authHeader){
        User user= userService.getUserFromToken(authHeader);
        
        return repo.findByIdAndUser(id, user);
    }

    @Override
    public List<Expense> getAll(String authHeader){
        User user= userService.getUserFromToken(authHeader);
        return repo.findByUser(user);
    }

    @Override
    public Expense updateById(Long id, Expense e, String authHeader){
        User user= userService.getUserFromToken(authHeader);
        Expense existing = repo.findByIdAndUser(id, user)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Expense not Found: " + id));
        existing.setUser(e.getUser());
        existing.setAmount(e.getAmount());
        existing.setCategory(e.getCategory());
        existing.setDescription(e.getDescription());

        return repo.save(existing);
    }

    @Override
    public Expense deleteById(Long id, String authHeader){
        User user= userService.getUserFromToken(authHeader);
        Expense existing = repo.findByIdAndUser(id, user)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Expense not Found: " + id));
        repo.delete(existing);
        return existing;
    }
}