package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    private static final By DASHBOARD_ICON = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getDashboardPageTitle(){
        return driver.getTitle();
    }

    public boolean isDashboardIconVisible(){
        return driver.findElement(DASHBOARD_ICON).isDisplayed();
    }

}
