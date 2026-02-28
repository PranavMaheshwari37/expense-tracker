package com.pranav.expensetracker.service;

import com.pranav.expensetracker.dto.ExpenseRequestDto;
import com.pranav.expensetracker.dto.ExpenseResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

    // ================= CREATE =================
    ExpenseResponseDto addExpenseForUser(Long userId, ExpenseRequestDto dto);

    // ================= USER-SPECIFIC READ =================
    List<ExpenseResponseDto> getExpensesForUser(Long userId);

    Double getTotalExpenseForUser(Long userId);

    // ================= GLOBAL READ =================
    List<ExpenseResponseDto> getAllExpenses();

    ExpenseResponseDto getExpenseById(Long id);

    List<ExpenseResponseDto> getByCategory(String category);

    List<ExpenseResponseDto> getByDateRange(LocalDate start, LocalDate end);

    Double getTotalExpense();
}