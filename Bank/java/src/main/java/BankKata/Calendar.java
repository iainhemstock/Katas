package BankKata;

import java.text.SimpleDateFormat;

public class Calendar {

    private static final String DD_MM_YYYY = "dd/MM/yyyy";

    public TransactionDate today() {
        String today = this.todayAsString();
        return new TransactionDate(today);
    }

    protected String todayAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY);
        String today = dateFormat.format(new java.util.Date());
        return today;
    }

}
