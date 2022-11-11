package com.eurotech.test.day11_Waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();

    }

    @Test
    public void Task() {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.alertIsPresent());  //Burda alert çıkana kadar bekle diyoruz

        Alert alert = driver.switchTo().alert();  // Burda Alert classına geçiş yapıyoruz.

        System.out.println("alert.getText() = " + alert.getText());

        Assert.assertEquals(alert.getText(),"This alert appeared after 5 seconds");

        alert.accept();

    }
}
