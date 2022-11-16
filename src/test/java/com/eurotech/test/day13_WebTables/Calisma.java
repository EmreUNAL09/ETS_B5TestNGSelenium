package com.eurotech.test.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calisma {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        WebElement table1 = driver.findElement(By.xpath("//h3[text()='Demo Table 1']"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",table1);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(1000);
        driver.close();

    }
    @Test
    public void calisma(){
        WebElement tableDemo1 = driver.findElement(By.xpath("//table[@id='customers']"));

        System.out.println("tableDemo1.getText() = " + tableDemo1.getText());

        Assert.assertTrue(tableDemo1.getText().contains("Island Trading"));

    }
    @Test
    public void getAllHeaders(){

        //get all Column headers
        List<WebElement> headers = driver.findElements(By.xpath("//tbody[@style='box-sizing: inherit;']/tr/th"));

        System.out.println("headers.size() = " + headers.size()); // size: 3

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText()); // Company Contact Country
        }

        //to get all Row headers

    }
}
