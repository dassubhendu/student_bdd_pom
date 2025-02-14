package com.pages;

import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private static final By USER_NAME = By.id("email");
    private static final By PASSWORD = By.id("loginPaswd");
    private static final By LOGIN_BUTTON = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    };

    public void enterUsername(String username){
        driver.findElement(USER_NAME).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException {
        driver.findElement(LOGIN_BUTTON).click();
        Thread.sleep(7000);
    }

    public boolean verifyValidInvalidLoginWithURL(String URL) throws InterruptedException {
        return driver.getCurrentUrl().equals(URL);
    }

    public DashboardPage doLogin(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        Thread.sleep(10000);
        return new DashboardPage(this.driver);
    }

}
