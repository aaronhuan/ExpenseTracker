package com.aaronhuang.expensetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaronhuang.expensetracker.model.Income;
import com.aaronhuang.expensetracker.service.IncomeService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/incomes")
public class IncomeController {
    private final IncomeService iSvc;
    public IncomeController(IncomeService iSvc) {
        this.iSvc = iSvc;
    }

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomes = iSvc.getAll();
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        Optional<Income> income = iSvc.getById(id);
        return ResponseEntity.of(income);
    }

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody @Valid Income income) {
        Income created = iSvc.create(income);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody @Valid Income income) {
        Income updated = iSvc.updateById(id, income);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Income> deleteIncome(@PathVariable Long id) {
        iSvc.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}