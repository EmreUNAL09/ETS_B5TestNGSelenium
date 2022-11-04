package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    //Testleri alfabetik , numaretik şekilde yapar.


    @Test
    public void test1(){
        System.out.println("First Test Case");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("open the browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("close the browser");
    }

    @Test
    public void test2(){
        System.out.println("Test Case 2");
    }

    @Test
    public void test3(){
        System.out.println("Test Case 3");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("-----------BEFORE CLASS-----------");
        System.out.println("BEFORE CLASS her class da bir defa calisir");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----AFTER CLASS------");
        System.out.println("AFTER CLASS her class da bir defa calisir");
    }

    @Ignore  @Test   //veya @Test 'i comment satırına alarak testin çalışmasını önleyebilirz.
    public void test4(){
        System.out.println("Ignore");
    }
}
