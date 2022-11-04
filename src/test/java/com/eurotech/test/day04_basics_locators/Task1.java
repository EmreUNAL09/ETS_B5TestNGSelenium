package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        /* Class Task
     *  go to the url -  "https://www.browserstack.com/users/sign_up"
     *  maximize the window
     *  accept cookies if any ,
     *  fill in the blanks with the faker class
     *  click "Term of service" checkbox
     *  and close the window
     *  hint: u can use any locator you want
     */


        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.browserstack.com/users/sign_up");

        Thread.sleep(1000);

        driver.manage().window().maximize();

        Thread.sleep(1000);

        //*  accept cookies if any
        driver.findElement(By.cssSelector("#accept-cookie-notification")).click();

        Thread.sleep(1000);

        WebElement fullName = driver.findElement(By.id("bs-auth-input-fullname"));

        Thread.sleep(1000);

        //fullName.sendKeys(faker.name().firstName().concat(" ").concat(faker.name().lastName()));

        fullName.sendKeys(faker.name().fullName());

        Thread.sleep(1000);

        WebElement businessEmail = driver.findElement(By.cssSelector("#bs-auth-input-email"));
        businessEmail.sendKeys(faker.internet().emailAddress());
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("#bs-auth-input-password"));

        password.sendKeys(faker.name().prefix().concat(faker.number().digits(6)));

        Thread.sleep(1000);

        //driver.findElement(By.cssSelector("#tnc_checkbox")).click();

        WebElement checkBox = driver.findElement(By.cssSelector("#tnc_checkbox"));

        Thread.sleep(3000);

        checkBox.click();
        Thread.sleep(2000);

        driver.close();


    }
}
