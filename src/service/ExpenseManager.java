package service;

import model.Expense;
import ui.ExpenseCategory;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpenseManager {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(String description, Double amount, ExpenseCategory category, String date) {
        Expense expense = new Expense(description, amount, category, LocalDate.parse(date));
        expenses.add(expense);
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

    public List<Expense> getAllExpensesSortedByDateAsc() {
        return expensesSortedByNewestDate(expenses);
    }

    public List<Expense> getAllExpensesSortedByDateDesc() {
        return expensesSortedByOldestDate(expenses);
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

    public List<Expense> getAllExpensesSortedByAmountAsc() {
        return expensesSortedByAmountAsc(expenses);
    }
    public List<Expense> getAllExpensesSortedByAmountDesc() {
        return expensesSortedByAmountDesc(expenses);
    }
}
