package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
        driver.quit();   //tüm tabları kapatır
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();

        Thread.sleep(2000);

        //String titleAfterClick = driver.getTitle();

        String currentTab = driver.getWindowHandle(); // title The Internet and has ID: it will change every time

        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles();
        // Set'ler uniqu objeler kabul eder. bu yüzden burda Set'i kullanıyoruz.
        // first and most important thing HasSet is a
        // collection of an items where every item is unique!

        for (String tab : windowHandles) { // go and check one by one
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void multipleWindows(){
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            //if (driver.getTitle().equals("New Window")){
            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
                break;
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}