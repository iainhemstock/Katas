package BankKata;

import java.util.Objects;

public class TransactionAmount {

    private int amount;

    public TransactionAmount(int amount) {
        this.amount = amount;
    }

    public final TransactionAmount negated() {
        return new TransactionAmount(-amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionAmount transactionAmount = (TransactionAmount) o;
        return amount == transactionAmount.amount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.valueOf(this.amount);
    }
}
