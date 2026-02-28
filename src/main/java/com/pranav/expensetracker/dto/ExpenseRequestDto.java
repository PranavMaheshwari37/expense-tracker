package com.pranav.expensetracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequestDto {

    @NotNull
    private String title;

    @NotNull
    private String category;

    @Positive
    private Double amount;

    @NotNull
    private LocalDate expenseDate;

    private String description;
}