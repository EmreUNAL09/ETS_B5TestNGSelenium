package com.eurotech.test.day21_FinalReview;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest extends TestBase {

    // Y A P I L A C A K !!!!!!

    /**Class Task
     * create test data with Swag labs user credentials and Product page for verify by using Excel
     * and execute this data set with extendReports
     * Hint : use product page title to verify
     */


    @DataProvider
    public Object [][] sauceUserData() {

        ExcelUtil sauceDemo = new ExcelUtil("src/test/resources/SauceDemo.XLSX",
                "SauceDemo");

        return sauceDemo.getDataArrayWithoutFirstRow();

    }

    @Test(dataProvider = "sauceUserData")
    public void ddfLoginTest(String username, String password, String products) {

        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest(username + "'s Login Test");


//        extentLogger.info("Click understand button");
//        loginPage.understandBtn_Loc.click();
        // 1. WAY
//        extentLogger.info("Enter username");
//        loginPage.userNameInput_loc.sendKeys(username);
//
//        extentLogger.info("Enter password");
//        loginPage.passwordInput_loc.sendKeys(password);
//
//        extentLogger.info("Click login button");
//        loginPage.loginBtn_loc.click();

        // 2.WAY
        extentLogger.info("User Name And Password");
        loginPage.login_Method(username,password);

        extentLogger.info("Urunler mtd");   /******/
        loginPage.productsText_Mtd(products);


        extentLogger.info("Urunler");
        Assert.assertEquals(loginPage.productsText.getText(),"PRODUCTS");


        extentLogger.pass("PASSED");

    }

}