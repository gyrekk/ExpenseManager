package ui;

import model.Expense;
import service.ExpenseManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
        System.out.println("2 - Delete Expense");
        System.out.println("3 - Show All Expenses");
        System.out.println("4 - Show Category Expenses");
        System.out.println("5 - Show Last Expenses");
        System.out.println("6 - Show Upcoming Expenses");
        System.out.println("X - Exit");
        System.out.print("Choose an option: ");
    }

    private String readDescription() {
        while (true) {
            System.out.print("Enter expense description: ");
            String input = scanner.nextLine().trim();
            if(!input.isEmpty()) {
                return input;
            }
            System.out.print("Description cannot be empty. Try again.\n");
        }
    }

    private double readAmount() {
        while (true) {
            System.out.print("Enter amount: ");
            String inputString = scanner.nextLine().trim();
            try {
                double amount = Double.parseDouble(inputString);
                if(amount > 0) {
                    return amount;
                }
                System.out.println("Amount must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Amount must be a number.");
            }
        }
    }
    private ExpenseCategory readCategory() {
        while (true) {
            try {
                System.out.print("Enter expense category: ");
                return ExpenseCategory.valueOf(scanner.nextLine().toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category");
            }
        }
    }
    private LocalDate readDate() {
        while (true) {
            try {
                System.out.print("Enter expense date template[yyyy-mm-dd] (skip if date is today): ");
                String input = scanner.nextLine().trim();
                LocalDate date;
                if(input.isEmpty()) {
                    date = LocalDate.now();
                } else {
                    date = LocalDate.parse(input);
                }
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date");
            }
        }
    }

    public void addNewExpense() {
        System.out.println("Adding new Expense");

        String description = readDescription();
        double amount = readAmount();
        ExpenseCategory category = readCategory();
        LocalDate date =  readDate();

        expenseManager.addExpense(description, amount, category, date);
        System.out.println("New Expense has been added");
    }

    public void deleteExpense() {
        System.out.println("Deleting new Expense");

        String description = readDescription();
        try {
            expenseManager.deleteExpense(description);
            System.out.println("Expense has been deleted");
        } catch (IllegalArgumentException e) {
            System.out.println("Expense does not exist");
        }
    }

    public void showAllExpenses() {
        List<Expense> allExpenses = expenseManager.getAllExpenses();
        expensePrinter.displayExpenses(allExpenses, "ALL");
        sortList(allExpenses, "ALL");
    }

    public void showLastExpenses() {
        List<Expense> lastExpenses = expenseManager.getRecentExpenses();
        expensePrinter.displayExpenses(lastExpenses, "LAST");
    }

    public void showUpcomingExpenses() {
        List<Expense> upcomingExpenses = expenseManager.getUpcomingExpenses();
        expensePrinter.displayExpenses(upcomingExpenses, "UPCOMING");
    }

    public void showCategoryExpenses() {
        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine().toUpperCase().trim();

        try {
            ExpenseCategory selectedCategory = ExpenseCategory.valueOf(categoryName);
            List<Expense> categoryExpenses = expenseManager.getExpensesByCategory(selectedCategory);

            expensePrinter.displayAllExpensesWithoutCategory(categoryExpenses, categoryName);

            sortList(categoryExpenses, categoryName);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category name");
            System.out.println("Available categories: " + Arrays.toString(ExpenseCategory.values()));
        }
    }

    public void sortList(List<Expense> expenses, String categoryName) {
        while (true) {
            System.out.println("Sorting options");
            System.out.println("1 - Newest expenses first");
            System.out.println("2 - Oldest expenses first");
            System.out.println("3 - Higher amount expenses first");
            System.out.println("4 - Lower amount expenses first");
            System.out.println("x - Return to menu");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            List<Expense> sortedExpenses;

            switch (choice) {
                case "1" -> sortedExpenses = expenseManager.expensesSortedByNewestDate(expenses);
                case "2" -> sortedExpenses = expenseManager.expensesSortedByOldestDate(expenses);
                case "3" -> sortedExpenses = expenseManager.expensesSortedByAmountDesc(expenses);
                case "4" -> sortedExpenses = expenseManager.expensesSortedByAmountAsc(expenses);
                case "X" -> {
                    return;
                }
                default -> {
                    System.out.println("Wrong choice");
                    sortedExpenses = expenses;
                }
            }
            expensePrinter.displayExpenses(sortedExpenses, categoryName);
        }
    }

    public void run() {
        while (isRunning) {
            showOptions();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addNewExpense();
                case "2" -> deleteExpense();
                case "3" -> showAllExpenses();
                case "4" -> showCategoryExpenses();
                case "5" -> showLastExpenses();
                case "6" -> showUpcomingExpenses();
                case "x" -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Wrong choice");
            }
            System.out.println();
        }
    }



}
