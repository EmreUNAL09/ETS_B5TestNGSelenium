package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_Fatih_Bey {
    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/dynamic_loading

        //Homework

        //Example 2: Element rendered after the fact -->click
        //click that element
        //verify that hello world is not displayed
        //click start button
        //verify that hello element is displayed
        //and verify that "Hello World!" text is present

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@href='/dynamic_loading/2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Thread.sleep(6000);

        Thread.sleep(5000);
        WebElement helloWorld= driver.findElement(By.xpath("//*[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());
        System.out.println("helloWorld.getText() = " + helloWorld.getText());

        //driver.close();




    }
}

