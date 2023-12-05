package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage {

    public static final String ESTIMATE_FILTER_OPTION = "(//div[contains(text(), '%s')])[1]/ancestor::span[1]/preceding-sibling::span[1]/span";

    public static final String SPINNER = "[data-testid='overlay-card'";
    public static final String HOTEL_PICTURE = "//div[@data-testid='property-card'][1]//a[1]";

    private WebDriver driver;
    private WebDriverWait wait;


    public HotelsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void filterByEstimate(String estimate) {
        driver.findElement(By.xpath(String.format(ESTIMATE_FILTER_OPTION, estimate))).click();
    }

    public void waitTillSpinnerClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(SPINNER)));
    }

    public void clickFirstHotelPicture() {
        driver.findElement(By.xpath(HOTEL_PICTURE)).click();
    }

    public void getHotelEstimate() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[aria-label='Оценка превосходно'"))));
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
