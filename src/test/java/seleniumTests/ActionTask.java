package seleniumTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ActionTask {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.cssSelector("#accept-choices")).click();

        Actions action = new Actions(driver);
        WebElement tutorialElement = driver.findElement(By.cssSelector(".color_h1"));
        action
                .doubleClick(tutorialElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.get("https://google.com");
        driver.findElement(By.xpath("(//div[contains(text(), 'Принять все')])[2]")).click();
        WebElement searchField = driver.findElement(By.name("q"));
        action
                .click(searchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .build()
                .perform();

        List<String> list = Arrays.asList("tutorial", "tutorials", "туториал");
        boolean isAnyTextPresent = list.stream()
                .anyMatch(text -> {
                    List<WebElement> elements = driver.findElements(By.xpath(
                            String.format("//div[@id='rso']//h3[contains(text(), '%s')]", text)
                    ));
                    return !elements.isEmpty();
                });
        Assert.assertTrue(isAnyTextPresent);
        driver.quit();
    }
}
