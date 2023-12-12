package pages.w3schools;

import driver.DriverInit;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePageW3School {

    public static final String ACCEPT_BTN = "#accept-choices";
    public static final String TUTORIAL_HEADING_PART = ".color_h1";

    private WebDriver driver = DriverInit.getWebDriver();

    public void navigateToW3School() {
        driver.get("https://www.w3schools.com/java/");
    }

    public void copyTutorialText() {
        WebElement tutorialElement = driver.findElement(By.cssSelector(TUTORIAL_HEADING_PART));
        log.info("Copy Tutorial text using keyboard");
        new Actions(driver)
                .doubleClick(tutorialElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void acceptAll() {
        log.info("Accept ccokies");
        driver.findElement(By.cssSelector(ACCEPT_BTN)).click();
    }

}
