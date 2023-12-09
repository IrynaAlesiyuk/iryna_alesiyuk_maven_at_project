package tests;

import driver.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void initDriver() {
        driver = DriverInit.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
