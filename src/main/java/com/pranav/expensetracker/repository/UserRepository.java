package com.pranav.expensetracker.repository;

import com.pranav.expensetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}