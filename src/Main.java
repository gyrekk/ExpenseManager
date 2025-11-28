import service.ExpenseManager;
import ui.ExpenseCategory;
import ui.ExpensePrinter;
import ui.Menu;

void main() {

    ExpenseManager expenseManager = new ExpenseManager();
    ExpensePrinter expenseConsoleView = new ExpensePrinter();

    expenseManager.addExpense("Paliwo na wyjazd", 400.00, ExpenseCategory.TRANSPORT, LocalDate.parse("2025-07-10"));
    expenseManager.addExpense("Obiady na wyjeździe", 550.00, ExpenseCategory.FOOD, LocalDate.parse("2025-07-15"));
    expenseManager.addExpense("Bilet do aquaparku", 120.00, ExpenseCategory.ENTERTAINMENT, LocalDate.parse("2025-07-16"));
    expenseManager.addExpense("Karnet na festiwal", 450.00, ExpenseCategory.ENTERTAINMENT, LocalDate.parse("2025-08-05"));
    expenseManager.addExpense("Lody i gofry", 45.00, ExpenseCategory.FOOD, LocalDate.parse("2025-08-20"));
    expenseManager.addExpense("Kurs Programowania Java", 299.00, ExpenseCategory.EDUCATION, LocalDate.parse("2025-09-01"));
    expenseManager.addExpense("Książki techniczne", 120.00, ExpenseCategory.EDUCATION, LocalDate.parse("2025-09-10"));
    expenseManager.addExpense("Wymiana opon na zimowe", 180.00, ExpenseCategory.TRANSPORT, LocalDate.parse("2025-10-25"));
    expenseManager.addExpense("Szczepienie psa", 90.00, ExpenseCategory.HOME, LocalDate.parse("2025-10-15"));
    expenseManager.addExpense("Wizyta u dentysty", 450.00, ExpenseCategory.HEALTH, LocalDate.parse("2025-03-10"));
    expenseManager.addExpense("Zakupy spożywcze Lidl", 185.50, ExpenseCategory.FOOD, LocalDate.parse("2025-03-15"));
    expenseManager.addExpense("Ubezpieczenie OC samochodu", 1100.00, ExpenseCategory.TRANSPORT, LocalDate.parse("2025-04-05"));
    expenseManager.addExpense("Netflix subskrypcja", 45.00, ExpenseCategory.ENTERTAINMENT, LocalDate.parse("2025-04-20"));
    expenseManager.addExpense("Grill ze znajomymi", 120.00, ExpenseCategory.FOOD, LocalDate.parse("2025-05-02"));
    expenseManager.addExpense("Bilet na pociąg (Majówka)", 85.00, ExpenseCategory.TRAVEL, LocalDate.parse("2025-05-01"));
    expenseManager.addExpense("Prezent dla siostry", 200.00, ExpenseCategory.GIFTS, LocalDate.parse("2026-01-05"));
    expenseManager.addExpense("Rezerwacja hotelu (Zaliczka)", 600.00, ExpenseCategory.TRAVEL, LocalDate.parse("2025-06-15"));
    expenseManager.addExpense("Nowe okulary przeciwsłoneczne", 150.00, ExpenseCategory.CLOTHING, LocalDate.parse("2025-06-20"));
    expenseManager.addExpense("Nowa klawiatura mechaniczna", 350.00, ExpenseCategory.ELECTRONICS, LocalDate.parse("2025-11-26"));
    expenseManager.addExpense("Spotify Premium", 20.00, ExpenseCategory.ENTERTAINMENT, LocalDate.parse("2025-11-10"));
    expenseManager.addExpense("Prezenty pod choinkę", 600.00, ExpenseCategory.GIFTS, LocalDate.parse("2025-12-20"));
    expenseManager.addExpense("Zakupy na Wigilię", 400.00, ExpenseCategory.FOOD, LocalDate.parse("2025-12-23"));
    expenseManager.addExpense("Karnet na siłownię", 129.00, ExpenseCategory.HEALTH, LocalDate.parse("2025-01-02"));
    expenseManager.addExpense("Czynsz Styczeń", 2500.00, ExpenseCategory.HOME, LocalDate.parse("2025-01-10"));
    expenseManager.addExpense("Zimowe buty", 350.00, ExpenseCategory.CLOTHING, LocalDate.parse("2025-01-20"));
    expenseManager.addExpense("Kolacja Walentynkowa", 250.00, ExpenseCategory.FOOD, LocalDate.parse("2025-02-14"));
    expenseManager.addExpense("Paliwo Orlen", 320.00, ExpenseCategory.TRANSPORT, LocalDate.parse("2025-02-25"));
    expenseManager.addExpense("Prezent dla mamy", 200.00, ExpenseCategory.GIFTS, LocalDate.parse("2024-10-08"));

    Menu menu = new Menu(expenseManager, expenseConsoleView);
    menu.run();





}
