package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement userInputBox = driver.findElement(By.cssSelector("#userName"));
        System.out.println("getAttribute() = " + userInputBox.getAttribute("id"));
        System.out.println("getAttribute() = " + userInputBox.getAttribute("class"));
        System.out.println("getAttribute() = " + userInputBox.getAttribute("type"));
        System.out.println("getAttribute() = " + userInputBox.getAttribute("placeholder"));
        System.out.println("getAttribute() = " + userInputBox.getAttribute("autocomplete"));

        System.out.println("getAttribute(\"outerHTML\") = " + userInputBox.getAttribute("outerHTML"));
        System.out.println("getAttribute(\"innerHTML\") = " + userInputBox.getAttribute("innerHTML"));


        driver.close();

    }


}
