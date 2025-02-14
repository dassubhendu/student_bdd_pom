package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RosterMgmtPage {

    private WebDriver driver;

    private static final By ROSTER_MGMT_DATA_TEXT = By.xpath("//label[contains(text(), 'Roster Management')]");

    public RosterMgmtPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isRosterMgmtTextVisible(){
        return driver.findElement(ROSTER_MGMT_DATA_TEXT).isDisplayed();
    }

}
