package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void task2() throws InterruptedException {
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

        WebElement example2Click = driver.findElement(By.xpath("//a[contains(text(),' after the fact')]"));
        example2Click.click();

        Thread.sleep(1000);

        // Ödeve göre bu aşamada Hello World! görünüyor mu ona bakıyoruz.
        // Fakat bu aşamada gözükmediği için test hata veriyor
        /* WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        System.out.println("helloWorld.isDisplayed() = " + helloWorld.isDisplayed()); */

        WebElement startBTN = driver.findElement(By.xpath("//div[@id='start']/button")); /*  veya //div/button , css ile  #start>button  */
        startBTN.click();

        Thread.sleep(5000);

        WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());
        System.out.println("helloWorld.isDisplayed() = " + helloWorld.isDisplayed());
        System.out.println("getText() = " + helloWorld.getText());

        Thread.sleep(1000);

        driver.close();

    }
}
