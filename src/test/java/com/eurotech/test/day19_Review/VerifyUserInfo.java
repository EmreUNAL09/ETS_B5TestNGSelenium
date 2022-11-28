package com.eurotech.test.day19_Review;

import com.eurotech.pages.ToolsQALoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    /*
    -Test1
    -Create new user

    -Test2
    -Login as a new user
    -Verify that login is successful
    -Click on go to book store
    -Verify that went book store
    -Search 'Addy Osmani' in search button
     */


    ToolsQALoginPage toolsQALoginPage = new ToolsQALoginPage();

    @Test
    public void newUserCreate(){

        extentLogger = report.createTest("User Create Info Verification");

        extentLogger.info("Click on new user button");
        toolsQALoginPage.newUserBtn.click();

        extentLogger.info("Enter first name");
        toolsQALoginPage.firstNameInput.sendKeys("Euro");

        extentLogger.info("Enter last name");
        toolsQALoginPage.lastNameInput.sendKeys("tech");

        extentLogger.info("Enter user name");
        toolsQALoginPage.userNameInput.sendKeys("Eurotech");

        extentLogger.info("Enter password");
        toolsQALoginPage.passwordInput.sendKeys("Eurotech12!");

        extentLogger.info("Click on the I'm not a robot");
        //'CAPTCHA' can not locate
        toolsQALoginPage.iAmNotARobotBtn.click();

        extentLogger.info("Click on the register button");
        toolsQALoginPage.registerBtn.click();
    }

    @Test
    public void loginInfo(){
        extentLogger = report.createTest("User Info Verification");

        extentLogger.info("Enter user name");
        toolsQALoginPage.userNameLoginInput.sendKeys(ConfigurationReader.get("userToolsQA"));

        extentLogger.info("Enter password");
        toolsQALoginPage.passwordLoginInput.sendKeys(ConfigurationReader.get("passwordToolsQA"));

        extentLogger.info("Click on the login button");
        toolsQALoginPage.loginBtn.click();

        //1. WAY
        extentLogger.info("Verify that login is successful");
        String expectedUrl ="https://demoqa.com/profile";
        BrowserUtils.waitFor(2);   //////////////
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        //2. WAY
        String expectedVerifyMessage = "Eurotech";
        extentLogger.info("Verify that login is successful" + expectedVerifyMessage);

        String actualVerifyMessage = toolsQALoginPage.verifyUserName.getText();

        Assert.assertEquals(actualVerifyMessage,expectedVerifyMessage);


        extentLogger.info("click on the Go To Store button");
        actions.moveToElement( toolsQALoginPage.goToStoreBtn).click();
        //BrowserUtils.clickWithJS(toolsQALOginPage.goToStoreBtn);
        // toolsQALOginPage.goToStoreBtn.click();

        extentLogger.info("Enter search button 'Addy Osmani' ");
        toolsQALoginPage.typeToSearchBtn.sendKeys("Addy Osmani");

        extentLogger.info("PASSS");





    }












}
