package BankKata;

import java.util.Objects;

public class Transaction {

    private final TransactionDate transactionDate;
    private final Money money;

    public Transaction(TransactionDate transactionDate, Money money) {
        this.transactionDate = transactionDate;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transactionDate, money);
    }

    public void addDateToStringBuilder(StringBuilder sb) {
        sb.append(this.transactionDate.toString());
    }

    public void addAmountToStringBuilder(StringBuilder sb) {
        sb.append(this.money.toString());
    }

    public int amountAsInt() {
        return Integer.parseInt(this.money.toString());
    }
}
