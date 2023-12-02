package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildberriesTest1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.wildberries.by");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Принять')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Главное меню']"))).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Дом')]"))).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Гостиная')]")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Коробки для хранения')]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@aria-label='Фильтры'])[1]"))).click();
        //  WebElement filters = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@aria-label='Фильтры'])[1]/span")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'до 5 дней')]"))).click();

        // String foundGoods = driver.findElement(By.cssSelector(".filters-sidebar__total-desktop")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".filters-sidebar__close"))).click();
        Thread.sleep(1000);
        String foundGoods = driver.findElement(By.cssSelector(".total-goods")).getText();

        System.out.println(foundGoods);
    }
}
