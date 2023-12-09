package pages.booking;

import driver.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HotelsPage {

    public static final String ESTIMATE_FILTER_OPTION = "(//div[contains(text(), '%s')])[1]/ancestor::span[1]/preceding-sibling::span[1]/span";
    public static final String SPINNER = "[data-testid='overlay-card'";
    public static final String HOTEL_PICTURE = "//div[@data-testid='property-card'][1]//a[1]";
    public static final String HIGHEST_ESTIMATE = "[aria-label='Оценка превосходно'";

    private WebDriver driver = DriverInit.getWebDriver();


    public void filterByEstimate(String estimate) {
        driver.findElement(By.xpath(String.format(ESTIMATE_FILTER_OPTION, estimate))).click();
    }

    public void waitTillSpinnerClosed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(SPINNER)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void clickFirstHotelPicture() {
        driver.findElement(By.xpath(HOTEL_PICTURE)).click();
    }

    public void getHotelEstimate() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(HIGHEST_ESTIMATE))));
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
