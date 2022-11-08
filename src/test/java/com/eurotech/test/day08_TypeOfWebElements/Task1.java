package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
    @Test
    public void task1() throws InterruptedException {
        //Class Task
        //complete the task
        //click all the checkbox
        //than assert that is selected or not

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(1000);

        //1.Klik
        WebElement firstClick = driver.findElement(By.xpath("//input[@type='checkbox']"));
        firstClick.click();
        System.out.println("firstClick.isSelected() = " + firstClick.isSelected());
        Assert.assertTrue(firstClick.isSelected()); //assert: True,  condition: True,  test:PASS

        Thread.sleep(2000);

        //2.Klik
        WebElement secondClick = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        secondClick.click(); //Bu sayfada normalde default olarak 2. click seçili geliyor
                            //burada yaptığımız komut ile bir daha tıklayınca tıkı kalkıyor,
                            //yani seçili olmaktan çıkıyor!
        System.out.println("secondClick.isSelected() = " + secondClick.isSelected());
        Assert.assertFalse(secondClick.isSelected()); //assert: false,  condition: false,  test:PASS

        Thread.sleep(3000);

        driver.close();
    }
}
