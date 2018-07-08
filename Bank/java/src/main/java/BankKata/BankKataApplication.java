package BankKata;

public class BankKataApplication {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        TransactionRepository transactionRepository = new InMemoryTransactionRepository(calendar);
        Console console = new Console();
        StatementPrinter statementPrinter = new ConsoleStatementPrinter(console);
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(new TransactionAmount(500));
        account.withdraw(new TransactionAmount(150));
        account.deposit(new TransactionAmount(200));

        account.printStatement();
    }
}
