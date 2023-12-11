package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingTest.class})
public class JUnitRunner {


}
