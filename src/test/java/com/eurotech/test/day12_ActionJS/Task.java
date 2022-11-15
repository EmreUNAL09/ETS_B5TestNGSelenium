package com.eurotech.test.day12_ActionJS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task {
//    Task
//    go to https://the-internet.herokuapp.com/hovers url
//    and get "view profile" elements' text (all of them)
//    and verify element is displayed (one by one)
//
//    hind: Use list and for loop

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
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']"));

        for (WebElement element : elements) {
            action.moveToElement(element).perform();
            System.out.println("element.isDisplayed() = " + element.isDisplayed());
            System.out.println("element.getText() = " + element.getText());
        }
    }
}