package model;

import java.time.LocalDate;

public record Expense(String description, Double amount, ui.ExpenseCategory category, LocalDate date) {}
