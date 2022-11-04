package com.eurotech.test.day03_WebElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChange {
    public static void main(String[] args) {

        //open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to "http://eurotech.study/login"
        driver.get("http://eurotech.study/login");


        //click I understand button
        driver.findElement(By.id("rcc-confirm-button")).click();

        //click to login btn
        //String name = "ali";
        //int num = 4;
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));

        loginBtn.click();

        //verify not changed is Url
        String expectedUrl = "http://eurotech.study/login";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.close();

    }
}
