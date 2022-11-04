package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement verifyInputs = driver.findElement(By.tagName("h3"));
        System.out.println("getText = " + verifyInputs.getText());

        WebElement verifyNumber = driver.findElement(By.tagName("p"));
        System.out.println("getText = " + verifyNumber.getText());

        //driver.get("https://the-internet.herokuapp.com/inputs");
        //System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = " + driver.findElement(By.tagName("h3")).getText());
        //System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());
    }
}
