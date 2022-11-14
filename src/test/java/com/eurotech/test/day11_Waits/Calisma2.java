package com.eurotech.test.day11_Waits;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Calisma2 {
    public static void main(String[] args) throws InterruptedException {

    //1.DERS
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(".....");

//        public static WebDriver getDriver (String browserType){
//
//            WebDriver driver = null;
//
//            switch (browserType.toLowerCase()) {
//
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    break;
//            }
//            return driver;
//        }

    //2.DERS
        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        Thread.sleep(1000);

        String expectedTitle = "";
        String actualTitle = driver.getTitle();

        driver.close();
        driver.quit();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        String currentURL = driver.getCurrentUrl();

        driver.navigate().to("........");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

    //3.DERS
        driver.findElement(By.id(".....")).click();

        WebElement emailInputBTN = driver.findElement(By.id("......."));

        emailInputBTN.sendKeys("......");





    }
}