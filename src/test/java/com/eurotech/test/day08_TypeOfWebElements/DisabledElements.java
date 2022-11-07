package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    /*What is disabled elements?
    Disable means: You can not interact the element, you can not click or you can not write
     */
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement disableElement = driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(disableElement.isEnabled(),"Verify that element is not eneabled");

        //if we click the enable button it will be interactive.

        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));

        enableButton.click();

        //there is a process and we add wait.
        Thread.sleep(4000);
        Assert.assertTrue(disableElement.isEnabled(), "Verify that element is enable");

        Thread.sleep(1000);
        driver.close();


    }
}
