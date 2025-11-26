package ui;

import model.Expense;
import service.ExpenseManager;

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
        System.out.println();
        System.out.println("All Expenses");
        ExpensePrinter.displayAllTasks(ExpenseManager.getAllExpenses());
    }

    public void showExpensesByCategory() {

        System.out.println();
        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine();
        System.out.println(categoryName + " Expenses");
        ExpensePrinter.displayAllTasks(ExpenseManager.getExpensesByCategory(categoryName));
    }

    public void run() {
        while (isRunning) {
            showOptions();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> System.out.println("Add New Expense");
                case "2" -> showAllExpenses();
                case "3" -> showExpensesByCategory();
                case "x" -> {
                    System.out.println("paaa");
                    isRunning = false;
                }
            }
            System.out.println();
        }

    }



}
