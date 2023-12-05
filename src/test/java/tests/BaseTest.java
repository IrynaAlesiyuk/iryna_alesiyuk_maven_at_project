package tests;

import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class BaseTest {
   public WebDriver driver;
   public  WebDriverWait wait;

    @BeforeClass
    public void initDriver() {
        driver = WebDriverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
