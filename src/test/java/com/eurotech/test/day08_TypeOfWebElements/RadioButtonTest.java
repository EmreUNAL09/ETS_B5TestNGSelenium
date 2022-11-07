package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        WebElement cookies = driver.findElement(By.xpath("//button[@id='btnCookie']"));
        cookies.click();

        Thread.sleep(1000);

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/..//input"));


        System.out.println("isSelected() = " + vegetablesRadio.isSelected());

        Assert.assertTrue(vegetablesRadio.isSelected(), "verify that vegetable radio is selected");

        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/..//input"));

        Assert.assertFalse(legumesRadio.isSelected(), "verify that radio is NOT selected");

        //legumesRadio.click();

        WebElement legum = driver.findElement(By.xpath("//div[text()='Legumes']/..//div"));
        legum.click();

        Thread.sleep(2000);

        Assert.assertTrue(legumesRadio.isSelected(), "verify that legumes radio is selected");


        driver.close();

    }

}
