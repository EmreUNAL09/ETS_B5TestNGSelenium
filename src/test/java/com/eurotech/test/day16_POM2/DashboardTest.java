package com.eurotech.test.day16_POM2;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    @Test
    public void dashboardMenu(){

        /*
        Class Task
        Go to http://eurotech.study/login
        Login with teacher credentials
        Get the text of the dashboard and verify following menu
            Developers
            All Posts
            My Account
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();

        String expectedText = "Welcome Teacher";

        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in succesfuly");

        //1. WAY
        for (WebElement menu : dashboardPage.menuList_loc) {
            System.out.println("menu.getText() = " + menu.getText());
        }

//        //2. WAY
//        List<WebElement> dashboardMenu = dashboardPage.menuList_loc;
//
//        for (WebElement menu : dashboardMenu){
//            System.out.println("menu.getText() = " + menu.getText());
//        }
    }

    @Test
    public void navigateMenu(){

        /** ClassTask
         Go to http://92.205.106.232/login
         Login with teacher credentials
         Navigate to All Posts menu and verify url is http://eurotech.study/posts
         Navigate to Developers menu and verify url is http://eurotech.study/profiles
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in successfully");

        dashboardPage.allPosts_loc.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");

        dashboardPage.developers_loc.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");

    }


    @Test
    public void navigate2() {

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in successfully");

        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");

    }


}
