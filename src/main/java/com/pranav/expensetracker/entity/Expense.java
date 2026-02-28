package com.pranav.expensetracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String category;

    private Double amount;

    private LocalDate expenseDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}