package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BookingTest2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://booking.com");
        String currentWindowHandle = driver.getWindowHandle();

        // driver.findElement(By.cssSelector("[aria-label='Скрыть меню входа в аккаунт.']")).click();

        //driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click(); промахивается мимо кнопки
        WebElement decline = driver.findElement(By.cssSelector("#onetrust-reject-all-handler"));
        decline.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(decline));
        driver.findElement(By.cssSelector("[aria-label='Куда вы хотите поехать?']")).sendKeys("Прага");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#autocomplete-result-0"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("[aria-label='Скрыть меню входа в аккаунт.']")).click();

        driver.findElement(By.xpath("(//div[contains(text(), '9+')])[1]/ancestor::span[1]/preceding-sibling::span[1]/span")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid='overlay-card'")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//a[1]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));


        //  String currentWindowHandle = driver.getWindowHandle();
        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to new window (iterate through handles and switch if not the current window)
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[aria-label='Оценка превосходно'"))));
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
        driver.quit();
    }
}
