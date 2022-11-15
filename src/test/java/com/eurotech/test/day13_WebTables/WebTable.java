package com.eurotech.test.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        WebElement demoTable = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;   //bu metodu googledan bulduk
        jse.executeScript("arguments[0].scrollIntoView(true);", demoTable);  //bu metodu googledan bulduk
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void printTable() throws InterruptedException {

        WebElement tableDemo = driver.findElement(By.xpath("//table[@border='1']"));

        System.out.println("tableDemo.getText() = " + tableDemo.getText());

        Assert.assertTrue(tableDemo.getText().contains("Mecca"));


    }
    @Test
    public void getAllHeaders(){

        //get all Column headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead//th"));

        //get size
        System.out.println("allHeaders.size() = " + allHeaders.size());  // size : 7

        //to get all Headers --> use foreach loop

        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }

        //to get all Row headers
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        //get size
        System.out.println("allRows.size() = " + allRows.size());

        //to get all Row --> use foreach loop
        for (WebElement allRow : allRows) {
            System.out.println("allRow.getText() = " + allRow.getText());
        }
    }
    @Test
    public void getRows(){
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        System.out.println("allRows.size() = " + allRows.size());

        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));

        System.out.println("clockTower.getText() = " + clockTower.getText());

        for (int i = 1; i <= allRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+i+"]"));
            System.out.println(i+". row = " + row.getText());
        }
    }
    @Test
    public void getAllCell(){

        //task -> get Burj Khalifa's info as a list

        List<WebElement> burjKhalifa = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));

        System.out.println("burjKhalifa.size() = " + burjKhalifa.size());  // size : 6

        Assert.assertEquals(burjKhalifa.size(),6);

        for (WebElement burj : burjKhalifa) {
            System.out.println("burj.getText() = " + burj.getText());
        }
    }
    @Test
    public void getSingleCell(){
        //task one cell
        //get Height from Clock Tower Hotel
        //verify that height is 601m

        WebElement heightClockTowerHotel = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));

        System.out.println("heightClockTowerHotel.getText() = " + heightClockTowerHotel.getText());

        Assert.assertEquals(heightClockTowerHotel.getText(),"601m");
    }
    @Test
    public void printAllCellByIndex(){
        //we need nested loop
        //we need methods

        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumn();

        System.out.println("rowNumber = " + rowNumber);  // size : 4
        System.out.println("columnNumber = " + columnNumber); // size : 7

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {
            //iterate through each row cell in the row
            for (int j = 1; j < columnNumber; j++) {
                String cellPath = "//table[@border='1']/tbody/tr["+i+"]/td["+j+"]"; //
                //System.out.println("cellPath = " + cellPath);
                WebElement cells = driver.findElement(By.xpath(cellPath));
                System.out.println("cells.getText() = " + cells.getText());
            }
        }
    }
    private int getNumberOfColumn() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        return columns.size();
    }
    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }
}