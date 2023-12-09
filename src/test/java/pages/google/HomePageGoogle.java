package pages.google;

import driver.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class HomePageGoogle {

    public static final String ACCEPT_ALL_BTN = "(//div[contains(text(), 'Принять все')])[2]";
    public static final String SEARCH_FIELD_BY_NAME = "q";

    private WebDriver driver = DriverInit.getWebDriver();


    public void navigateToGooglePage() {
        driver.get("https://google.com");
    }

    public void acceptAll() {
             driver.findElement(By.xpath(ACCEPT_ALL_BTN)).click();
//        try {
//            WebElement cookies = new WebDriverWait(driver, Duration.ofSeconds(15))
//                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ACCEPT_ALL_BTN)));
//            cookies.click();
//            System.out.println("Accept all cookies");
//        } catch (Exception e) {
//            System.out.println("Accept all cookies Element did not appear within the specified time.");
//        }
    }

    public void pastedCopiedTextIntoSearchField() {
        WebElement searchField = driver.findElement(By.name(SEARCH_FIELD_BY_NAME));
        new Actions(driver)
                .click(searchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .build()
                .perform();
    }

    public boolean checkIfTutorialIsFound() {
        List<String> list = Arrays.asList("tutorial", "tutorials", "туториал");
        boolean isAnyTextPresent = list.stream()
                .anyMatch(text -> {
                    List<WebElement> elements = driver.findElements(By.xpath(
                            String.format("//div[@id='rso']//h3[contains(text(), '%s')]", text)
                    ));
                    return !elements.isEmpty();
                });
        return isAnyTextPresent;
    }
}
