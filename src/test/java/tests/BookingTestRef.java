package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.booking.HomePage;
import pages.booking.HotelsPage;

import java.time.Duration;
import java.time.LocalDate;

import static utils.WindowHandlerUtils.switchToNewOpenedWindow;

public class BookingTestRef extends BaseTest {

    @BeforeMethod
    public void navigateToPage() {
        driver.get("https://booking.com");
    }

    @Test
    public void enterFilterParameters() throws InterruptedException {
        HomePage bookingHomePage = new HomePage(driver, wait);

        rejectCookiesAndHideMenu(bookingHomePage);

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

    @Test
    public void findHotelWithHighestEstimate() throws InterruptedException {
        HomePage bookingHomePage = new HomePage(driver, wait);
        HotelsPage hotelsPage = new HotelsPage(driver, wait);
        String currentWindowHandle = driver.getWindowHandle();

        rejectCookiesAndHideMenu(bookingHomePage);
        bookingHomePage.selectDestination("Прага");
        bookingHomePage.clickFindBtn();
      //  rejectCookiesAndHideMenu(bookingHomePage);
        hotelsPage.filterByEstimate("9+");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        hotelsPage.waitTillSpinnerClosed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        hotelsPage.clickFirstHotelPicture();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        switchToNewOpenedWindow(driver, currentWindowHandle);
        hotelsPage.getHotelEstimate();
    }

    private void rejectCookiesAndHideMenu(HomePage homePage) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        homePage.rejectCookies();
        homePage.hideMenuEnteranceToAccount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
