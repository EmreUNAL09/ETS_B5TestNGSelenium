package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        /*Locator XPATH PRACTICES
        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        1. Open Chrome browser
        2. Go to https://the-internet.herokuapp.com/forgot_password Links to an
        external site.
        3. Locate all the WebElements on the page using XPATH locator only
        a. “Forgot password” header
        b. “E-mail” text
        c. E-mail input box
        d. “Retrieve password” button
        4.Print text of a,b,d and put some email to c.*/

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPassword = driver.findElement(By.xpath("//h2[text()='Forgot Password'] "));

        String actualText1 = forgotPassword.getText();

        //String actualText1 = driver.findElement(By.xpath("//h2[contains(text(),'Forgot Password')]")).getText();

        String expectedText ="Forgot Password";

        if (actualText1.equals(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        WebElement emailTextText = driver.findElement(By.xpath("//label[text()='E-mail']"));

        String actualText2 = emailTextText.getText();

        String expectedText2 = "E-mail";

        if (actualText2.equals(expectedText2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        WebElement emailInput = driver.findElement(By.xpath("//label[text()='E-mail']/following-sibling :: *"));

        emailInput.sendKeys(faker.internet().emailAddress());

        Thread.sleep(1000);

        WebElement retrievePassword = driver.findElement(By.xpath("//button[contains(@id,'form_submit')]"));

        retrievePassword.click();

        Thread.sleep(2000);

        driver.close();


    }
}
