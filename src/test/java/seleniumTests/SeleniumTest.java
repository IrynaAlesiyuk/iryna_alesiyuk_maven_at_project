package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class SeleniumTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
      //   WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
      //  driver.findElement(By.name("q")).sendKeys("погода минск");
      //  Thread.sleep(500);
      //  driver.findElement(By.xpath("//ul[@role='listbox'/li(1)"));

       // List<WebElement> list= driver.findElements(By.xpath("//div[@aria-label='суббота']/../.."));
      //  list.get(1).click();
       // driver.findElement(By.xpath("//div[contains"));

    }
}
