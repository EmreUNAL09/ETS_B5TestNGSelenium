package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://eurotech.study/");

        Thread.sleep(2000);

        driver.close(); //close current tab

        //giving new browser tab ==> if we dont it will give invalid session Id Exception
        driver = new ChromeDriver();

        driver.get("https://tr-tr.facebook.com/");

        Thread.sleep(2000);

        driver.quit(); //close all tabs

    }
}
