package service;

import model.Expense;
import ui.ExpenseCategory;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExpenseManager {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(String description, Double amount, ExpenseCategory category, LocalDate date) {
        Expense expense = new Expense(description, amount, category, date);
        expenses.add(expense);
    }
    public Optional<Expense> getExpense(String description) {
        return expenses.stream()
                .filter(e -> e.description().equalsIgnoreCase(description))
                .findFirst();
    }

    public void deleteExpense(String description) {
        Optional<Expense> expense = getExpense(description);
        if (expense.isPresent()) {
            expenses.remove(expense.get());
        } else throw new IllegalArgumentException();
    }

    // Getters
    public List<Expense> getAllExpenses() {
        return List.copyOf(expenses);
    }

    public List<Expense> getExpensesByCategory(ExpenseCategory category) {
        return expenses.stream()
                .filter(e -> e.category().equals(category))
                .toList();
    }

    public List<Expense> getExpensesByMonth(Month month, int year) {
        return expenses.stream()
                .filter(e -> e.date().getMonth() == month)
                .filter(e -> e.date().getYear() == year)
                .toList();
    }

    public List<Expense> getExpensesByYear(int year) {
        return expenses.stream()
                .filter(e -> e.date().getYear() == year)
                .toList();
    }

    public List<Expense> getRecentExpenses() {
        LocalDate today = LocalDate.now();
        return expenses.stream()
                .filter(e -> !e.date().isAfter(today))
                .sorted(Comparator.comparing(Expense::date).reversed())
                .limit(10)
                .toList();
    }

    public List<Expense> getUpcomingExpenses() {
        LocalDate today = LocalDate.now();
        return expenses.stream()
                .filter(e -> e.date().isAfter(today))
                .sorted(Comparator.comparing(Expense::date))
                .limit(10)
                .toList();
    }

    // Total expenses
    public double sumOfExpenses(List<Expense> expenses) {
        return expenses.stream()
                .mapToDouble(Expense::amount)
                .sum();
    }

    public double totalExpenses() {
        return sumOfExpenses(expenses);
    }

    public double totalYearlyExpenses(int year) {
        return sumOfExpenses(getExpensesByYear(year));
    }

    public double totalMonthlyExpenses(Month month, int year) {
        return sumOfExpenses(getExpensesByMonth(month, year));
    }

    // Sorted by date

    public List<Expense> expensesSortedByNewestDate(List<Expense> expenses) {
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::date).reversed()) // e -> e.date()
                .toList();
    }

    public List<Expense> expensesSortedByOldestDate(List<Expense> expenses) {
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::date))
                .toList();
    }

    // Sorted by amount

    public List<Expense> expensesSortedByAmountAsc(List<Expense> expenses) { // ASC - lowest to highest amount
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::amount)) // e -> e.date()
                .toList();
    }

    public List<Expense> expensesSortedByAmountDesc(List<Expense> expenses) { // ASC - highest to lowest amount
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::amount).reversed())
                .toList();
    }
}
