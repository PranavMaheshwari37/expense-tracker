package com.pranav.expensetracker.controller;

import com.pranav.expensetracker.dto.ExpenseResponseDto;
import com.pranav.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseQueryController {

    private final ExpenseService expenseService;

    public ExpenseQueryController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // 4️⃣ Get ALL expenses (global)
    @GetMapping
    public List<ExpenseResponseDto> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // 5️⃣ Get expense by ID
    @GetMapping("/{id}")
    public ExpenseResponseDto getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // 6️⃣ Get expenses by category
    @GetMapping("/category/{category}")
    public List<ExpenseResponseDto> getByCategory(@PathVariable String category) {
        return expenseService.getByCategory(category);
    }

    // 7️⃣ Get expenses by date range
    @GetMapping("/date-range")
    public List<ExpenseResponseDto> getByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end
    ) {
        return expenseService.getByDateRange(start, end);
    }

    // 8️⃣ Get TOTAL expense (global)
    @GetMapping("/total")
    public Double getTotalExpense() {
        return expenseService.getTotalExpense();
    }
}