package model;

import java.time.LocalDate;

public record Expense(String description, Double amount, String category, LocalDate date) {}
