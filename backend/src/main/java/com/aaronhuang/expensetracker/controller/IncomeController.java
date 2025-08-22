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
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/api/v1/incomes")
public class IncomeController {
    private final IncomeService iSvc;
    public IncomeController(IncomeService iSvc) {
        this.iSvc = iSvc;
    }

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes(@RequestHeader("Authorization") String authHeader) {
        List<Income> incomes = iSvc.getAll(authHeader);
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id, @RequestHeader("Authorization") String authHeader) {
        Optional<Income> income = iSvc.getById(id, authHeader);
        return ResponseEntity.of(income);
    }

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody @Valid Income income, @RequestHeader("Authorization") String authHeader) {
        Income created = iSvc.create(income, authHeader);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody @Valid Income income, @RequestHeader("Authorization") String authHeader) {
        Income updated = iSvc.updateById(id, income, authHeader);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Income> deleteIncome(@PathVariable Long id, @RequestHeader("Authorization") String authHeader) {
        iSvc.deleteById(id, authHeader);
        return ResponseEntity.noContent().build();
    }

}