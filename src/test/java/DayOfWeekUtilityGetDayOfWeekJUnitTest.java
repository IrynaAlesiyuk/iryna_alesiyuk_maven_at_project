import org.junit.Assert;
import org.junit.Test;

public class DayOfWeekUtilityGetDayOfWeekJUnitTest {

    @Test
    public void validEqualToOne() {
        String actual = DayOfWeekUtility.getDayOfWeek(1);
        Assert.assertEquals(actual, "Monday");
    }

    @Test
    public void validEqualToSeven() {
        String actual = DayOfWeekUtility.getDayOfWeek(7);
        Assert.assertEquals(actual, "Sunday");
    }

    @Test
    public void invalidLessThanOne() {
        String actual = DayOfWeekUtility.getDayOfWeek(0);
        Assert.assertEquals(actual, "Invalid day number. Please provide a number between 1 and 7.");
    }

    @Test
    public void invalidMoreThanSeven() {
        String actual = DayOfWeekUtility.getDayOfWeek(8);
        Assert.assertEquals(actual, "Invalid day number. Please provide a number between 1 and 7.");
    }
}
