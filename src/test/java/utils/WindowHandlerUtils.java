package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandlerUtils {

    public static void switchToNewOpenedWindow(WebDriver driver, String currentWindowHandle){
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
