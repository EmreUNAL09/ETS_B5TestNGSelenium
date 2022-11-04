package com.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        //We have to enter this line every time we want to open chrome/firefox/safari...

        WebDriverManager.chromedriver().setup();

        //WEBDRIVER represent the browser
        //We are creating driver for chrome browser

        WebDriver driver = new ChromeDriver(); //polymorphism

        driver.get("https://www.eurotechstudy.com/");




        /*WebDriverManager.edgedriver().setup();

        WebDriver driver1 = new EdgeDriver();

        driver1.get("https://www.eurotechstudy.com/");*/


        /*WebDriverManager.firefoxdriver().setup();

        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.eurotechstudy.com/");*/


    }
}
