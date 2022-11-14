package com.eurotech.test.day12_ActionJS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //WebDriverWait wait = new WebDriverWait(driver, 15);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void clickWithJS() {
        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Germany"));

        //ask google to --> how to click with js executor!  //bu bölümü googleda sorduk ve stackover.com da bulduk!
        JavascriptExecutor executor = (JavascriptExecutor)driver;  //bu metodu googledan bulduk
        executor.executeScript("arguments[0].click();", germany);  //bu metodu googledan bulduk

    }
    @Test
    public void typeWithJS(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text = "Hello World!";

        //ask to google --> How to sendKeys using with JS executor?
        JavascriptExecutor jse = (JavascriptExecutor)driver;  //bu metodu googledan bulduk
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);  //bu metodu googledan bulduk

    }
    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        //ask google --> How to scroll down in selenium JS executor?
        JavascriptExecutor jse = (JavascriptExecutor)driver;   //bu metodu googledan bulduk

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");   //bu metodu googledan bulduk
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");  //bu metodu googledan bulduk
        }
    }
    @Test
    public void scrollToElement(){
        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Germany"));

        //ask google --> How to scroll into view with selenium JS executor?
        JavascriptExecutor jse = (JavascriptExecutor)driver;   //bu metodu googledan bulduk
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);  //bu metodu googledan bulduk

        jse.executeScript("arguments[0].click();", germany);  //bu metodu googledan bulduk












    }
}
