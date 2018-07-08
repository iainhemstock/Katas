package BankKata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CalendarShould {

    public static final String TODAY = "02/12/2013";

    @Test
    public void return_todays_date() {
        TransactionDate expectedDate = new TransactionDate(TODAY);
        Calendar calendar = new TestableCalendar();
        assertThat(calendar.today(), is(expectedDate));
    }

    class TestableCalendar extends Calendar {
        @Override
        protected String todayAsString() {
            return CalendarShould.TODAY;
        }
    }
}

