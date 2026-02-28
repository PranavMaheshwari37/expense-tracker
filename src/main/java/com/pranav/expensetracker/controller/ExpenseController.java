package com.pranav.expensetracker.controller;

import com.pranav.expensetracker.dto.ExpenseRequestDto;
import com.pranav.expensetracker.dto.ExpenseResponseDto;
import com.pranav.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // ✅ 1. Add expense for a user
    @PostMapping("/{userId}/expenses")
    public ExpenseResponseDto addExpenseForUser(
            @PathVariable Long userId,
            @Valid @RequestBody ExpenseRequestDto dto
    ) {
        return expenseService.addExpenseForUser(userId, dto);
    }

    // ✅ 2. Get ALL expenses for a user
    @GetMapping("/{userId}/expenses")
    public List<ExpenseResponseDto> getExpensesForUser(
            @PathVariable Long userId
    ) {
        return expenseService.getExpensesForUser(userId);
    }

    // ✅ 3. Get TOTAL expense for a user
    @GetMapping("/{userId}/expenses/total")
    public Double getTotalExpenseForUser(
            @PathVariable Long userId
    ) {
        return expenseService.getTotalExpenseForUser(userId);
    }
}