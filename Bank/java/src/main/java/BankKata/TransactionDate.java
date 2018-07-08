package BankKata;

import java.util.Objects;

public class TransactionDate {
    private String date;

    public TransactionDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDate transactionDate1 = (TransactionDate) o;
        return Objects.equals(date, transactionDate1.date);
    }

    @Override
    public String toString() {
        return this.date;
    }
}
