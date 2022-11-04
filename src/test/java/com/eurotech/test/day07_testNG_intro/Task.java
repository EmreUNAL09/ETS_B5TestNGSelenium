package com.eurotech.test.day07_testNG_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
//   -open chrome browser
//   -go to https://www.facebook.com/
//   -enter real username
//   -enter real password
//   -click login button
//   -verify that login successfully
//    Task2
//   -open chrome browser
//   -go to https://www.facebook.com/
//   -enter dummy username with using Faker class
//   -enter dummy password with using Faker class
//   -click login btn
//   -veriify that login Failed

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void facebookLogin(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("absc@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456hj");
        driver.findElement(By.name("login")).click();

        String expectedMessage = "Bu senin hesabın mı?";

        String actualMessage = driver.findElement(By.className("_9kpn")).getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(actualMessage,expectedMessage);
    }

}
