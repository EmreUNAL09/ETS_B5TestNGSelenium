package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
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
        driver.get("https://the-internet.herokuapp.com/iframe");

        //How to switch the Iframe

        //*** First way : using name or ID ***
        driver.switchTo().frame("mce_0_ifr");

        //driver.findElement(By.cssSelector("#tinymce")).sendKeys("EuroTECH");
        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        textArea.sendKeys("Eurotech Batch 5 was here");


        driver.switchTo().parentFrame();
        //*** Second way : switching index
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Eurotech Batch 5 was here for the 2nd time");


        driver.switchTo().parentFrame();
        //*** Third way : using web element
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("This is third way");


        Thread.sleep(2000);

    }

    @Test
    public void nestedIframe(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //switch to middle frame and get text
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());

        //go to Right frame and get text
            /*.switchTo().defaultContent();//Selenium switch the top
            driver.switchTo().frame("frame-top");  */
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());


        //go to bottom frame and get text
        driver.switchTo().defaultContent();
            /*driver.switchTo().parentFrame();
              driver.switchTo().parentFrame();*/
        /*1. yöntem ==> WebElement frameBottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(frameBottom);*/

        /*2. yöntem name veya ID ile ==> driver.switchTo().frame("frame-bottom"); */
        driver.switchTo().frame(1); //3.  yöntem
        System.out.println("driver.findElement(By.xpath(\"/html/body\")).getText() = " + driver.findElement(By.xpath("/html/body")).getText());



        //go to left frame and get text
        driver.switchTo().parentFrame();  //tekrar parenta çıkmamız gerekiyor
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

    }
}