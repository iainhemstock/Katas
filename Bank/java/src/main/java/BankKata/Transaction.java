package BankKata;

import java.util.Objects;

public class Transaction {

    private final TransactionDate transactionDate;
    private final TransactionAmount transactionAmount;

    public Transaction(TransactionDate transactionDate, TransactionAmount transactionAmount) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(transactionAmount, that.transactionAmount);
    }

    public void addDateToStringBuilder(StringBuilder sb) {
        sb.append(this.transactionDate.toString());
    }

    public void addAmountToStringBuilder(StringBuilder sb) {
        sb.append(this.transactionAmount.toString());
    }

    public int amountAsInt() {
        return Integer.parseInt(this.transactionAmount.toString());
    }
}
