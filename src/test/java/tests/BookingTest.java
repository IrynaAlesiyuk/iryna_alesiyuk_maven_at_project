package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.booking.HomePageBooking;
import pages.booking.HotelsPage;

import java.time.Duration;
import java.time.LocalDate;

import static utils.WindowHandlerUtils.switchToNewOpenedWindow;

public class BookingTest extends BaseTest {

    @BeforeMethod
    public void navigateToPage() {
        new HomePageBooking().navigateToBookingPage();
    }

    @Test
    public void enterFilterParameters() throws InterruptedException {
        HomePageBooking bookingHomePage = new HomePageBooking();
        bookingHomePage.rejectCookiesAndHideMenu();

        bookingHomePage.selectDestination("Париж");

        LocalDate currentDatePlus3 = LocalDate.now().plusDays(3);
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
        HomePageBooking bookingHomePage = new HomePageBooking();
        HotelsPage hotelsPage = new HotelsPage();
        String currentWindowHandle = driver.getWindowHandle();

        bookingHomePage.rejectCookiesAndHideMenu();
        bookingHomePage.selectDestination("Прага");
        bookingHomePage.clickFindBtn();
        hotelsPage.filterByEstimate("9+");

        hotelsPage.waitTillSpinnerClosed();

        hotelsPage.clickFirstHotelPicture();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        switchToNewOpenedWindow(driver, currentWindowHandle);
        hotelsPage.getHotelEstimate();
    }

    @Test
    public void checkLanguagePickerTooltip(){
        Assert.assertEquals(new HomePageBooking().getLanguagePickerTooltip(), "Выберите язык");
    }


}
