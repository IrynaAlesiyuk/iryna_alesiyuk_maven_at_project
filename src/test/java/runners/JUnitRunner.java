package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingTest;

public class JUnitRunner {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({BookingTest.class})
    public class JUnit4Suite {

    }
}
