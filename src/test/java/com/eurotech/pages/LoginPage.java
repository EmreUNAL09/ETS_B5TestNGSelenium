package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id= "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//form/div[3]/h3")
    public WebElement errorMessage;

    @FindBy(id = "rcc-confirm-button")
    public WebElement understed;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsText;

    @FindBy(xpath = "//form/div")
    public List<WebElement> listProducts;

    @FindAll({
            @FindBy(id = "user-name"),
            @FindBy(name = "user-name")
    })
    public WebElement getUsernameInput;

    @FindBys({
            @FindBy(xpath = "//input[@type'text']"),
            @FindBy(id = "password")
    })
    public WebElement getPasswordInput;




    public void login(){
        usernameInput.sendKeys(ConfigurationReader.get("userswag"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginBtn.click();
    }
    public void loginAsPerform(){
        String userName = ConfigurationReader.get("userPerform");
        String password = ConfigurationReader.get("passwordswag");
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsProblem(){
        String userName = ConfigurationReader.get("userProblem");
        String password = ConfigurationReader.get("passwordswag");
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
