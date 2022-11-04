package com.eurotech.test.day02_webdriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //driver.get("https://tr-tr.facebook.com/");

        Thread.sleep(2000);

        //driver.close();

        /*
        Task
        -go to the devEX website
        -expected title = DevEX
        -get title and verify that title is devEX
         */

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver1 = new ChromeDriver();
        driver.get("http://eurotech.study/");

        String expectedTitle = "DevEX";
        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle));
    }
}
