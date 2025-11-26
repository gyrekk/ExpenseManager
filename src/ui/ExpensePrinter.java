package ui;

import model.Expense;

import java.util.List;

public class ExpensePrinter {

    public static void displayAllTasks(List<Expense> expenses) {
        expenses.
            forEach(e -> System.out.println(
                e.description() + " " +
                e.category() + " " +
                e.amount() + " " +
                e.date()));
    }

    public void displayAllTasksWithoutCategory(List<Expense> expenses) {
        expenses.
                forEach(e -> System.out.println(
                        e.description() + " " +
                                e.amount() + " " +
                                e.date()));
    }
}
