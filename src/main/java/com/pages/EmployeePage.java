package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {

    private WebDriver driver;

    private static final By EMPLOYEE_DATA_TEXT = By.xpath("//label[contains(text(), 'Employee Data')]");

    public EmployeePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isEmployeeDataTextVisible(){
        return driver.findElement(EMPLOYEE_DATA_TEXT).isDisplayed();
    }


}
