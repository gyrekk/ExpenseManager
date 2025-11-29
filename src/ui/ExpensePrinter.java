package ui;

import model.Expense;

import java.util.List;

public class ExpensePrinter {

    public void displayExpenses(List<Expense> expenses, String category) {
        System.out.println(category + " expenses");
        expenses.
            forEach(e -> System.out.println(
                e.description() + " " +
                e.category() + " " +
                e.amount() + " " +
                e.date()));
    }

    public void displayAllExpensesWithoutCategory(List<Expense> expenses, String category) {
        System.out.println(category + " expenses");
        expenses.
                forEach(e -> System.out.println(
                        e.description() + " " +
                                e.amount() + " " +
                                e.date()));
    }
}

