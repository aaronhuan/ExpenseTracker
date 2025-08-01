package com.aaronhuang.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aaronhuang.expensetracker.model.Income;
import com.aaronhuang.expensetracker.repository.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository repo;
    public IncomeServiceImpl(IncomeRepository repo) {
        this.repo = repo;
    }
    @Override
    public Income create(Income income) {
        return repo.save(income);
    }

    @Override
    public Optional<Income> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Income> getAll() {
        return repo.findAll();
    }

    @Override
    public Income updateById(Long id, Income income) {
        Income existing = getById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Income not Found: " + id));
        existing.setUser(income.getUser());
        existing.setAmount(income.getAmount());
        existing.setSource(income.getSource());
        existing.setReoccuring(income.getReoccuring());
        existing.setFrequency(income.getFrequency());

        return repo.save(existing);
    }

    @Override
    public Income deleteById(Long id) {
        Income existing = getById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                            "Income not Found: " + id));
        repo.delete(existing);
        return existing;
    }
}