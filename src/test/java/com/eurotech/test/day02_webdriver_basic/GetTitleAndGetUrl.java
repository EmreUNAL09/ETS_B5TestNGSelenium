package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {
        //Task open chrome and navigate to http://www.eurotechstudy.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
       /* driver.get("http://www.eurotechstudy.com");

        //getting title with selenium
        String title = driver.getTitle();
        System.out.println("title = " + title);*/

        driver.get("https://tr-tr.facebook.com/");

        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle));

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        //get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
