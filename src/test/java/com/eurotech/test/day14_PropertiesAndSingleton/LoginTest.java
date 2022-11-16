package com.eurotech.test.day14_PropertiesAndSingleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    @Test
    public void openBrowserUsingConfigurationReader() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameB5"));

        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordB5")+ Keys.ENTER);

        Thread.sleep(2000);
        //e.g.
        //actions.moveToElement()
        //wait.until(ExpectedConditions.visibilityOf())

    }
}