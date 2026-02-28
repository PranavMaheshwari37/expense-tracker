package com.pranav.expensetracker.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExpenseResponseDto {

    private Long id;
    private String title;
    private String category;
    private Double amount;
    private LocalDate expenseDate;
    private String description;
}