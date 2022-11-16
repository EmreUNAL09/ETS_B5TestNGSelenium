package com.eurotech.test.day14_PropertiesAndSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);

        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }
    @Test
    public void openBrowserUsingConfigurationReader() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameB5"));

        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordB5")+ Keys.ENTER);

        Thread.sleep(2000);

    }
    @Test
    public void test(){
        WebDriverFactory.getDriver("chrome");
    }



}
