package pages.booking;

import driver.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class HomePageBooking {

    public static final String REJECT_COOKIES_BTN = "#onetrust-reject-all-handler";
    public static final String ACCEPT_COOKIES_BTN = "#onetrust-accept-btn-handler";
    public static final String CLOSE_OF_ACCOUNT_ENTERANCE_WINDOW = "[aria-label='Скрыть меню входа в аккаунт.']";
    public static final String DESTINATION_PLACE_FIELD = "[aria-label='Куда вы хотите поехать?']";
    public static final String FIRST_FOUND_DESTINATION_PLACE_MENU_ITEM = "#autocomplete-result-0";
    public static final String CALENDAR_SELECTED_ITEM = "//div[@id='calendar-searchboxdatepicker']//span[@data-date='%s']";
    public static final String OCCUPANCY_MENU = "[data-testid='occupancy-config']";
    public static final String ADULTS_PLUS_OPTION = "//input[@id='group_adults']/following-sibling::div[2]/button[2]";
    public static final String ROOMS_PLUS_OPTION = "//input[@id='no_rooms']/following-sibling::div[2]/button[2]";
    public static final String SUBMIT_BTN = "//button[@type='submit']";
    public static final String LANGUAGE_PICKER_BTN = "[data-testid='header-language-picker-trigger']";
    public static final String LANGUAGE_PICKER_TOOLTIL = "//div[@id=':r5:']/div";


    private WebDriver driver = DriverInit.getWebDriver();

    public void navigateToBookingPage() {
        driver.get("https://booking.com");
    }

    public void rejectCookiesAndHideMenu() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        rejectCookies();
        hideMenuEnteranceToAccount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    private void rejectCookies() {
        try {
            WebElement cookies = new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(REJECT_COOKIES_BTN)));
            cookies.click();
            System.out.println("Reject all cookies");
        } catch (Exception e) {
            System.out.println("Reject all cookies Element did not appear within the specified time.");
        }
//        new WebDriverWait(driver, Duration.ofSeconds(15))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(TimeoutException.class)
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(REJECT_COOKIES_BTN)))
//                .click();
    }

    private void hideMenuEnteranceToAccount() {
        try {
            WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_OF_ACCOUNT_ENTERANCE_WINDOW)));
            menu.click();
            System.out.println("Clicked on the element.");
        } catch (Exception e) {
            System.out.println("Element did not appear within the specified time.");
        }
//        new WebDriverWait(driver, Duration.ofSeconds(15))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(TimeoutException.class)
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_WINDOW_OF_ACCOUNT_ENTERANCE)))
//                .click();

    }

    public void selectDestination(String destinationName) throws InterruptedException {
        driver.findElement(By.cssSelector(DESTINATION_PLACE_FIELD)).sendKeys(destinationName);
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FIRST_FOUND_DESTINATION_PLACE_MENU_ITEM))).click();
    }

    public void selectDate(LocalDate date) {
        driver.findElement(By.xpath(String.format(CALENDAR_SELECTED_ITEM, date))).click();
    }

    public void openOccupancyMenu() {
        driver.findElement(By.cssSelector(OCCUPANCY_MENU)).click();
    }

    public void plusAdult() {
        driver.findElement(By.xpath(ADULTS_PLUS_OPTION)).click();
    }

    public void plusRooms() {
        driver.findElement(By.xpath(ROOMS_PLUS_OPTION)).click();
    }

    public void clickFindBtn() {
        driver.findElement(By.xpath(SUBMIT_BTN)).click();
        //Add hotel page is displayed
    }

    public String getLanguagePickerTooltip() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.cssSelector(LANGUAGE_PICKER_BTN)))
                .build()
                .perform();
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LANGUAGE_PICKER_TOOLTIL))).getText();

    }
}
