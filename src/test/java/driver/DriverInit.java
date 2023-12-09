package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {

    public static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (null == driver) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
