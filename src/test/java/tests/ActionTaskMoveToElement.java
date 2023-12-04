package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionTaskMoveToElement {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.cssSelector("[aria-label='Скрыть меню входа в аккаунт.']")).click();

        Actions actions = new Actions(driver);
        WebElement languagePicker = driver.findElement(By.cssSelector("[data-testid='header-language-picker-trigger']"));
        actions
                .moveToElement(languagePicker)
                .build()
                .perform();
        Thread.sleep(5000);
        String tooltipText = driver.findElement(By.xpath("//div[@id=':r5:']/div")).getText();
        System.out.println(tooltipText);

    }
}
