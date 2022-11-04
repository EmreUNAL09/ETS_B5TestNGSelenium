package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {
        /*Class Task
        go to Amazon web page
        write selenium to search box
        verify that the result

         */

        String pruduct = "iphone 11";

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com.tr/");

        //WebElement forgotPassword = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        //forgotPassword.click();
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();

        //WebElement searchBtn = driver.findElement(By.xpath("//input[@type='text']"));
        //searchBtn.sendKeys(pruduct);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(pruduct);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(1000);

        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Aranan ürün:')]/..")).getText();

        System.out.println("actualText = " + actualText);

        if (actualText.contains(pruduct)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(1000);

        driver.close();
    }
}
