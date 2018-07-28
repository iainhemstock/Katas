package com.iainhemstock;

import java.text.SimpleDateFormat;

public class Calendar {
    private static final String DATE_FORMAT_dd_MMM_yy = "dd MMM yy";

    public String today() {
        return this.todayAsString();
    }

    protected String todayAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_dd_MMM_yy);
        return dateFormat.format(new java.util.Date());
    }
}
