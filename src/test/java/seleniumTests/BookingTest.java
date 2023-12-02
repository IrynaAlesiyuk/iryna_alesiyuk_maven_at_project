package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class BookingTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://booking.com");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement cookies = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#onetrust-reject-all-handler")));
            cookies.click();
            System.out.println("Reject all cookies");
        } catch (Exception e) {
            System.out.println("Element did not appear within the specified time.");
        }

        try {
            WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Скрыть меню входа в аккаунт.']")));
            menu.click();
            System.out.println("Clicked on the element.");
        } catch (Exception e) {
            System.out.println("Element did not appear within the specified time.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.findElement(By.cssSelector("[aria-label='Куда вы хотите поехать?']")).sendKeys("Париж");
        driver.findElement(By.cssSelector("#autocomplete-result-0")).click();

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDatePlus3 = currentDate.plusDays(3);
        LocalDate currentDatePlus3Plus7 = currentDatePlus3.plusDays(7);
        driver.findElement(By.xpath(String.format("//div[@id='calendar-searchboxdatepicker']//span[@data-date='%s']", currentDatePlus3))).click();
        driver.findElement(By.xpath(String.format("//div[@id='calendar-searchboxdatepicker']//span[@data-date='%s']", currentDatePlus3Plus7))).click();

        driver.findElement(By.cssSelector("[data-testid='occupancy-config']")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div[2]/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div[2]/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='no_rooms']/following-sibling::div[2]/button[2]")).click();

        driver.quit();
    }
}
