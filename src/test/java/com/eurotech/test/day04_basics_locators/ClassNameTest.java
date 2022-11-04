package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

        WebElement underStandBtn = driver.findElement(By.id("rcc-confirm-button"));
        underStandBtn.click();

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("eurotechB5@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Test12345");

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);

        WebElement experienceTest = driver.findElement(By.className("my-2"));
        System.out.println("getText() = " + experienceTest.getText());

        //if there is a space in the className locator we can not use className locator
        //driver.findElement(By.className("navbar bg-dark"));




        //driver.close();
    }
}
