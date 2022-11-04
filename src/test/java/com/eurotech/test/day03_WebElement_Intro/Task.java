package com.eurotech.test.day03_WebElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {
    public static void main(String[] args) {
/*
        -open chrome browser
        -go to https://www.amazon.com
        -enter 'Java' in the search button
        -click on search  button
        -verify that title has changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to
        driver.get("https://www.amazon.com/");

        WebElement twotabsearchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
        twotabsearchtextbox.sendKeys("java");

        /*WebElement element = driver.findElement(By.id("nav-search-submit-button"));
        element.click();*/

        driver.findElement(By.id("nav-search-submit-button")).click();

        String expectedTitle = "Amazon.com : java";
        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.close();
    }
}
