package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WildberriesTest2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.by");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[contains(text(), 'Принять')]")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("[aria-label='Главное меню']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(text(), 'Зоотовары')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Аквариумистика')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Декорации')]")).click();

        Thread.sleep(1000);
        String totalGoods = driver.findElement(By.cssSelector(".total-goods")).getText();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@aria-label='Фильтры'])[1]")).click();

        driver.findElement(By.cssSelector("[data-id='3214']")).click();
        Thread.sleep(5000);

        WebElement type = driver.findElement(By.cssSelector("[data-id='125595']"));
        // new Actions(driver).scrollToElement(type).perform(); не находит элемент
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", type);

        Thread.sleep(5000);
        WebElement pack = driver.findElement(By.cssSelector("[data-id='129699']"));
        //new Actions(driver).scrollToElement(pack).perform(); не находит элемент
        jsExecutor.executeScript("arguments[0].click();", pack);

        Thread.sleep(5000); //errors here
        WebElement inputField = driver.findElement(By.cssSelector("[data-tag='inputMax']"));
        inputField.clear();
        Thread.sleep(5000);
        inputField.sendKeys("100");
        driver.findElement(By.cssSelector(".filters-sidebar__close")).click();
        Thread.sleep(2000);

        String totalGoodsAfterFiltering = driver.findElement(By.cssSelector(".total-goods")).getText();
        System.out.println("Total goods: " + totalGoodsAfterFiltering);
        int difference = Integer.valueOf(totalGoods) - Integer.valueOf(totalGoodsAfterFiltering);
        System.out.println("Разница: " + difference);

    }
}
