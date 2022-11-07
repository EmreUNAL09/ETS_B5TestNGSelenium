package com.eurotech.test.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title");
        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expected = "Curo";
        String actual = "Eurotech";

        Assert.assertTrue(actual.startsWith(expected));
        Assert.assertTrue(actual.startsWith(expected),"verify that title starting Euro");

        //Assert.assertFalse(actual.startsWith(expected));
    }

    @Test
    public void test4(){
        String email = "eurotech@gmail.com";

//        if (email.contains("@")){
//            System.out.println("PASS");
//        }else {
//            System.out.println("FAIL");
//        }


        Assert.assertTrue(email.contains("@"));
    }
    @Test
    public void test5(){
        Assert.assertFalse(0<1, "Verify that 0 is not greater than 1");
        //bizim burda beklediğimiz hata vermesi, fakat 0<1 olduğundan, yani doğru olduğundan
        // burda hata olur test kalır.
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("two","one");
        //bizim burda beklediğimiz hata vermesi, iki taraf farklı olduğundan, yani yanlış olduğundan
        // burda test geçer

        // expected: False
        // actual: False
        // test: PASS
    }

    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Open the browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close the browser");
    }

}
