package com.pranav.expensetracker.repository;

import com.pranav.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find expenses by category
    List<Expense> findByCategory(String category);

    // Find expenses between dates
    List<Expense> findByExpenseDateBetween(LocalDate start, LocalDate end);

    // Find all expenses for a user
    List<Expense> findByUserId(Long userId);

    // Get total expense for a user
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.user.id = :userId")
    Double getTotalExpenseByUserId(@Param("userId") Long userId);
}