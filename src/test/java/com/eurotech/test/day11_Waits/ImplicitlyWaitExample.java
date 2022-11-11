package com.eurotech.test.day11_Waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        //Her findElement'ten sonra çalışır.
        //İhtiyaç olan süre kadar çalışır.Mesela 20 saniye girdiğimizde ....
        //ImplicitlyWait bir Selenium metodudur.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Selenium version 4 için kullanılır
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void testName() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        WebElement element = driver.findElement(By.cssSelector("#checkbox-example>p"));

        System.out.println("element.getText() = " + element.getText());

        Assert.assertEquals(element.getText(), "It's gone!");

    }

    @Test
    public void implicitlyWait2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#input-example>button")).click();

        WebElement element = driver.findElement(By.cssSelector("#input-example>p"));

        System.out.println("element.getText() = " + element.getText());

        Assert.assertEquals(element.getText(), "It's enabled!");


    }
}
