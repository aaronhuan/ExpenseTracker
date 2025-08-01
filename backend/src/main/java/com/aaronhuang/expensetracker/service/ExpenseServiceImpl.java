package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaronhuang.expensetracker.model.Expense;

import com.aaronhuang.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository repo;
    
    public ExpenseServiceImpl(ExpenseRepository repo){
        this.repo = repo;
    }

    @Override 
    public Expense create(Expense e){
        return repo.save(e);
    }


    @Override
    public Optional<Expense> getById(Long id){
        return repo.findById(id);
    }

    @Override
    public List<Expense> getAll(){
        return repo.findAll();
    }

    @Override
    public Expense updateById(Long id, Expense e){
        Expense existing = getById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Expense not Found: " + id));
        existing.setUser(e.getUser());
        existing.setAmount(e.getAmount());
        existing.setCategory(e.getCategory());
        existing.setDescription(e.getDescription());

        return repo.save(existing);
    }

    @Override
    public Expense deleteById(Long id){
        Expense existing = getById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Expense not Found: " + id));
        repo.delete(existing);
        return existing;
    }
}