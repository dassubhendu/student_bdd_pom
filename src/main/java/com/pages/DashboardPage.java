package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    private static final By DASHBOARD_ICON = By.xpath("//span[contains(text(), 'Dashboard')]");
    private static final By EMPLOYEE_ICON = By.xpath("//span[contains(text(), ' Employees')]");
    private static final By ROSTER_ICON = By.xpath("//span[contains(text(), 'Roster Management')]");


    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isDashboardIconVisible(){
        return driver.findElement(DASHBOARD_ICON).isDisplayed();
    }

    public EmployeePage goToEmployeePage() throws InterruptedException {
        driver.findElement(EMPLOYEE_ICON).click();
        Thread.sleep(10000);
        return new EmployeePage(this.driver);
    }

    public RosterMgmtPage goToRosterMgmtPage() throws InterruptedException {
        driver.findElement(ROSTER_ICON).click();
        Thread.sleep(10000);
        return new RosterMgmtPage(this.driver);
    }

}
