package com.iainhemstock.unit;

import com.iainhemstock.Calendar;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalendarShould {

    private static final String TODAY = "04 Apr 14";
    private Calendar calendar = new TestableCalendar();

    @Test
    public void return_todays_date_as_string() {
        assertThat(calendar.today(), Is.is(equalTo(TODAY)));
    }

    class TestableCalendar extends Calendar {
        @Override
        protected String todayAsString() {
            return TODAY;
        }
    }

}
