package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class SeleniumTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //   WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//div[contains(text(), 'Принять все')])[2]")).click();

        driver.findElement(By.name("q")).sendKeys("погода минск");
        Thread.sleep(500);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
        Thread.sleep(1000);

        List<WebElement> list = driver.findElements(By.cssSelector("[data-wob-di]"));
        Thread.sleep(1000);
        list.get(1).click();

        Locale locale = Locale.getDefault();
        LocalDate currentDate = LocalDate.now().plusDays(2);
        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);

        WebElement element = driver.findElement(By.xpath(String.format("//*[contains(@aria-label,'Celsius %s 12:00')][1]", dayOfWeek.toLowerCase())));

        String[] parts = element.getAttribute("aria-label").split("°");
        System.out.println("Погода на завтра в 12: " + parts[0]);

        driver.quit();

    }
}
