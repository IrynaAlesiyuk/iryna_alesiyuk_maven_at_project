package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.booking.HomePage;

import java.time.Duration;
import java.time.LocalDate;

public class BookingTestRef extends BaseTest {

    @BeforeMethod
    public void navigateToPage() {
        driver.get("https://booking.com");
    }

    @Test
    public void enterFilterParameters() {
        HomePage bookingHomePage = new HomePage(driver, wait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        //waiter explicit
        bookingHomePage.rejectCookies();
        bookingHomePage.hideMenuEnteranceToAccount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        bookingHomePage.selectDestination("Париж");

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDatePlus3 = currentDate.plusDays(3);
        LocalDate currentDatePlus3Plus7 = currentDatePlus3.plusDays(7);
        bookingHomePage.selectDate(currentDatePlus3);
        bookingHomePage.selectDate(currentDatePlus3Plus7);

        bookingHomePage.openOccupancyMenu();
        bookingHomePage.plusAdult();
        bookingHomePage.plusAdult();
        bookingHomePage.plusRooms();
    }
}
