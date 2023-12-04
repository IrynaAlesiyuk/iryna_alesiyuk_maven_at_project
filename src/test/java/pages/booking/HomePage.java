package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class HomePage {

    public static final String REJECT_COOKIES_BTN = "#onetrust-reject-all-handler";
    public static final String ACCEPT_COOKIES_BTN = "#onetrust-accept-btn-handler";
    public static final String CLOSE_WINDOW_OF_ACCOUNT_ENTERANCE = "[aria-label='Скрыть меню входа в аккаунт.']";
    public static final String DESTINATION_PLACE = "[aria-label='Куда вы хотите поехать?']";
    public static final String FIRST_FOUND_DESTINATION_PLACE = "#autocomplete-result-0";
    public static final String CALENDAR = "//div[@id='calendar-searchboxdatepicker']//span[@data-date='%s']";
    public static final String OCCUPANCY = "[data-testid='occupancy-config']";
    public static final String ADULTS = "//input[@id='group_adults']/following-sibling::div[2]/button[2]";
    public static final String ROOMS_MENU = "//input[@id='no_rooms']/following-sibling::div[2]/button[2]";
    public static final String SUBMIT_BTN = "//button[@type='submit']";
    public static final String SPINNER = "[data-testid='overlay-card'";
    public static final String HOTEL_PICTURE = "//div[@data-testid='property-card'][1]//a[1]";

    private WebDriver driver;
    private WebDriverWait wait;


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void rejectCookies() {
        try {
            WebElement cookies = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(REJECT_COOKIES_BTN)));
            cookies.click();
            System.out.println("Reject all cookies");
        } catch (Exception e) {
            System.out.println("Reject all cookies Element did not appear within the specified time.");
        }
    }

    public void hideMenuEnteranceToAccount() {
        try {
            WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_WINDOW_OF_ACCOUNT_ENTERANCE)));
            menu.click();
            System.out.println("Clicked on the element.");
        } catch (Exception e) {
            System.out.println("Element did not appear within the specified time.");
        }
    }

    public void selectDestination(String destinationName) {
        driver.findElement(By.cssSelector(DESTINATION_PLACE)).sendKeys(destinationName);
        driver.findElement(By.cssSelector(FIRST_FOUND_DESTINATION_PLACE)).click();
    }

    public void selectDate(LocalDate date) {
        driver.findElement(By.xpath(String.format(CALENDAR, date))).click();
    }

    public void openOccupancyMenu() {
        driver.findElement(By.cssSelector(OCCUPANCY)).click();
    }

    public void plusAdult() {
        driver.findElement(By.xpath(ADULTS)).click();
    }

    public void plusRooms() {
        driver.findElement(By.xpath(ROOMS_MENU)).click();
    }


}
