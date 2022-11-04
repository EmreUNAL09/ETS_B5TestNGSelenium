package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");

        WebElement inputUserName = driver.findElement(By.id("userName"));

        //inputUserName.sendKeys("Mike");
        inputUserName.sendKeys(faker.name().firstName());

        Thread.sleep(3000);

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));

        //inputUserEmail.sendKeys("mike@gmaill.cöm");
        inputUserEmail.sendKeys(faker.internet().emailAddress());

        //driver.close();

    }
}
