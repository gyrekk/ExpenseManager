package ui;

import model.Expense;
import service.ExpenseManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final ExpenseManager expenseManager;
    private final ExpensePrinter expensePrinter;
    private final Scanner scanner;
    private boolean isRunning = true;

    public Menu(ExpenseManager expenseManager, ExpensePrinter  expensePrinter) {
        this.expenseManager = expenseManager;
        this.expensePrinter = expensePrinter;
        this.scanner = new Scanner(System.in);
    }

    private void showOptions() {
        System.out.println("EXPENSE MANAGER MENU");
        System.out.println("1 - Add New Expense");
        System.out.println("2 - Show All Expenses");
        System.out.println("3 - Show Category Expenses");
        System.out.println("4 - Show Sorted by Date (Oldest First)");
        System.out.println("5 - Show Sorted by Amount (Most Expensive First)");
        System.out.println("6 - Show Total Cost");
        System.out.println("X - Exit");
        System.out.print("Choose an option: ");
    }

//    private void addNewExpense() {
//
//        System.out.println("Enter Expense Name:");
//        String name = scanner.nextLine();
//        System.out.println("Enter Expense Amount:");
//        double amount = scanner.nextDouble();
//        System.out.println("Enter Expense Category:");
//        String category = scanner.nextLine();
//        System.out.println("Enter Expense Date:");
//        String date = scanner.nextLine();
//
//    }

    public void showAllExpenses() {
        List<Expense> allExpenses = expenseManager.getAllExpenses();
        expensePrinter.displayExpenses(allExpenses, "ALL");
        sortList(allExpenses);
    }

    public void sortList(List<Expense> expenses) {
        while (true) {
            System.out.println("Sorting options");
            System.out.println("1 - Newest expenses first");
            System.out.println("2 - Oldest expenses first");
            System.out.println("3 - Higher amount expenses first");
            System.out.println("4 - Lower amount expenses first");
            System.out.println("x - Back to menu");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            List<Expense> sortedExpenses;

            switch (choice) {
                case "1" -> sortedExpenses = expenseManager.expensesSortedByNewestDate(expenses);
                case "2" -> sortedExpenses = expenseManager.expensesSortedByOldestDate(expenses);
                case "3" -> sortedExpenses = expenseManager.expensesSortedByAmountDesc(expenses);
                case "4" -> sortedExpenses = expenseManager.expensesSortedByAmountAsc(expenses);
                case "x" -> {
                    System.out.println("paaa");
                    return;
                }
                default -> {
                    System.out.println("Wrong choice");
                    sortedExpenses = expenses;
                }
            }

            expensePrinter.displayExpenses(sortedExpenses, "ALL");

        }
    }

    public void showExpensesByCategory() {
        System.out.println();
        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine().toUpperCase().trim();
        try {
            ExpenseCategory selectedCategory = ExpenseCategory.valueOf(categoryName);

            System.out.println(categoryName + " Expenses");
            expensePrinter.displayAllTasksWithoutCategory(expenseManager.getExpensesByCategory(selectedCategory));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category name");
            System.out.println("Available categories: " + Arrays.toString(ExpenseCategory.values()));
        }
    }

    public void run() {
        while (isRunning) {
            showOptions();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> System.out.println("Add New Expense");
                case "2" -> showAllExpenses();
                case "3" -> showExpensesByCategory();
                case "x" -> {
                    System.out.println("paaa");
                    isRunning = false;
                }
                default -> System.out.println("Wrong choice");
            }
            System.out.println();
        }

    }



}
