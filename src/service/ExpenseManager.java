package service;

import model.Expense;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpenseManager {

    private static final List<Expense> expenses = new ArrayList<>();

    public static void addExpense(String description, Double amount, String category, String date) {
        Expense expense = new Expense(description, amount, category, LocalDate.parse(date));
        expenses.add(expense);
    }

    // Getters
    public static List<Expense> getAllExpenses() {
        return List.copyOf(expenses);
    }

    public static List<Expense> getExpensesByCategory(String category) {
        return expenses.stream()
                .filter(e -> e.category().equalsIgnoreCase(category))
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

    public List<Expense> expensesSortedByDateAsc(List<Expense> expenses) {
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::date)) // e -> e.date()
                .toList();
    }

    public List<Expense> expensesSortedByDateDesc(List<Expense> expenses) {
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::date).reversed())
                .toList();
    }

    public List<Expense> getAllExpensesSortedByDateAsc() {
        return expensesSortedByDateAsc(expenses);
    }

    public List<Expense> getAllExpensesSortedByDateDesc() {
        return expensesSortedByDateDesc(expenses);
    }

    // Sorted by amount

    public List<Expense> expensesSortedByAmountAsc(List<Expense> expenses) {
        return expenses.stream()
                .sorted(Comparator.comparing(Expense::amount)) // e -> e.date()
                .toList();
    }

    public List<Expense> expensesSortedByAmountDesc(List<Expense> expenses) {
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
