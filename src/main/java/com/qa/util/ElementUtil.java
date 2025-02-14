package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementUtil {
    private static WebDriver driver = null;
    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }
    public static void sendKeysToElement(By element, String value){
        try{
            WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(20));
            driver.findElement(element).sendKeys(value);
        }catch(Exception exp){
            System.out.println(exp);
        }
    }

}
