package com.eurotech.test.day14_PropertiesAndSingleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigurationReader.get("url"));
        WebElement userNameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        userNameInput.sendKeys(ConfigurationReader.get("usernameB5"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordB5") + Keys.ENTER);
    }
}
