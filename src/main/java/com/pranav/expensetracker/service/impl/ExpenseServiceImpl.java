package com.pranav.expensetracker.service.impl;

import com.pranav.expensetracker.dto.ExpenseRequestDto;
import com.pranav.expensetracker.dto.ExpenseResponseDto;
import com.pranav.expensetracker.entity.Expense;
import com.pranav.expensetracker.entity.User;
import com.pranav.expensetracker.repository.ExpenseRepository;
import com.pranav.expensetracker.repository.UserRepository;
import com.pranav.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseServiceImpl(
            ExpenseRepository expenseRepository,
            UserRepository userRepository
    ) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    // =========================
    // CREATE EXPENSE (USER BASED)
    // =========================
    @Override
    public ExpenseResponseDto addExpenseForUser(Long userId, ExpenseRequestDto dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense(
                null,
                dto.getTitle(),
                dto.getCategory(),
                dto.getAmount(),
                dto.getExpenseDate(),
                dto.getDescription(),
                user
        );

        Expense saved = expenseRepository.save(expense);
        return mapToDto(saved);
    }

    // =========================
    // READ (USER BASED)
    // =========================
    @Override
    public List<ExpenseResponseDto> getExpensesForUser(Long userId) {
        return expenseRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // =========================
    // READ (GLOBAL)
    // =========================
    @Override
    public List<ExpenseResponseDto> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public ExpenseResponseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        return mapToDto(expense);
    }

    @Override
    public List<ExpenseResponseDto> getByCategory(String category) {
        return expenseRepository.findByCategory(category)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ExpenseResponseDto> getByDateRange(LocalDate start, LocalDate end) {
        return expenseRepository.findByExpenseDateBetween(start, end)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // =========================
    // TOTALS
    // =========================
    @Override
    public Double getTotalExpense() {
        return expenseRepository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    @Override
    public Double getTotalExpenseForUser(Long userId) {
        Double total = expenseRepository.getTotalExpenseByUserId(userId);
        return total != null ? total : 0.0;
    }

    // =========================
    // DTO MAPPER
    // =========================
    private ExpenseResponseDto mapToDto(Expense expense) {
        return ExpenseResponseDto.builder()
                .id(expense.getId())
                .title(expense.getTitle())
                .category(expense.getCategory())
                .amount(expense.getAmount())
                .expenseDate(expense.getExpenseDate())
                .description(expense.getDescription())
                .build();
    }
}