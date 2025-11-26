import service.ExpenseManager;
import ui.ExpensePrinter;
import ui.Menu;

public class Main {

    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();
        ExpensePrinter expenseConsoleView = new ExpensePrinter();

        // --- LIPIEC (Wakacje!) ---
        ExpenseManager.addExpense("Paliwo na wyjazd", 400.00, "Transport", "2025-07-10");
        ExpenseManager.addExpense("Obiady na wyjeździe", 550.00, "Food", "2025-07-15");
        expenseManager.addExpense("Bilet do aquaparku", 120.00, "Entertainment", "2025-07-16");
// --- SIERPIEŃ (Festiwale) ---
        expenseManager.addExpense("Karnet na festiwal", 450.00, "Entertainment", "2025-08-05");
        expenseManager.addExpense("Lody i gofry", 45.00, "Food", "2025-08-20");
// --- WRZESIEŃ (Powrót do nauki/pracy) ---
        expenseManager.addExpense("Kurs Programowania Java", 299.00, "Education", "2025-09-01");
        expenseManager.addExpense("Książki techniczne", 120.00, "Education", "2025-09-10");
// --- PAŹDZIERNIK (Jesień) ---
        expenseManager.addExpense("Wymiana opon na zimowe", 180.00, "Transport", "2025-10-25");
        expenseManager.addExpense("Szczepienie psa", 90.00, "Home", "2025-10-15");
// --- MARZEC (Wiosna, zdrowie) ---
        expenseManager.addExpense("Wizyta u dentysty", 450.00, "Health", "2025-03-10");
        expenseManager.addExpense("Zakupy spożywcze Lidl", 185.50, "Food", "2025-03-15");
// --- KWIECIEŃ (Auto, opłaty) ---
        expenseManager.addExpense("Ubezpieczenie OC samochodu", 1100.00, "Transport", "2025-04-05");
        expenseManager.addExpense("Netflix subskrypcja", 45.00, "Entertainment", "2025-04-20");
// --- MAJ (Majówka) ---
        expenseManager.addExpense("Grill ze znajomymi", 120.00, "Food", "2025-05-02");
        expenseManager.addExpense("Bilet na pociąg (Majówka)", 85.00, "Travel", "2025-05-01");
// --- CZERWIEC (Początek lata) ---
        expenseManager.addExpense("Rezerwacja hotelu (Zaliczka)", 600.00, "Travel", "2025-06-15");
        expenseManager.addExpense("Nowe okulary przeciwsłoneczne", 150.00, "Clothing", "2025-06-20");
// --- LISTOPAD (Obecny miesiąc - Black Friday) ---
        expenseManager.addExpense("Nowa klawiatura mechaniczna", 350.00, "Electronics", "2025-11-26"); // Dzisiaj!
        expenseManager.addExpense("Spotify Premium", 20.00, "Entertainment", "2025-11-10");
// --- GRUDZIEŃ (Święta - przyszłość) ---
        expenseManager.addExpense("Prezenty pod choinkę", 600.00, "Gifts", "2025-12-20");
        expenseManager.addExpense("Zakupy na Wigilię", 400.00, "Food", "2025-12-23");
// --- STYCZEŃ (Zima, postanowienia noworoczne) ---
        expenseManager.addExpense("Karnet na siłownię", 129.00, "Health", "2025-01-02");
        expenseManager.addExpense("Czynsz Styczeń", 2500.00, "Home", "2025-01-10");
        expenseManager.addExpense("Zimowe buty", 350.00, "Clothing", "2025-01-20");
// --- LUTY (Zima, Walentynki) ---
        expenseManager.addExpense("Kolacja Walentynkowa", 250.00, "Food", "2025-02-14");
        expenseManager.addExpense("Paliwo Orlen", 320.00, "Transport", "2025-02-25");

//        expenseConsoleView.displayAllTasksWithoutCategory(expenseManager.getAllExpenses());


        Menu menu = new Menu(expenseManager, expenseConsoleView);
        menu.run();



    }
}
