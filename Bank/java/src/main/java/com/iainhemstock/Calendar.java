package com.iainhemstock;

import java.text.SimpleDateFormat;

public class Calendar {
    private static final String DD_MM_YYYY = "dd MMM yy";

    public String today() {
        return this.todayAsString();
    }

    protected String todayAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY);
        return dateFormat.format(new java.util.Date());
    }
}
