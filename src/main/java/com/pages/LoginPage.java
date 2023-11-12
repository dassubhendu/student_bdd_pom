package com.pages;

import com.sun.jdi.PrimitiveValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private static final By USER_NAME = By.name("username");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private static final By LINK_FORGOT_PASSWORD = By.xpath("//p[text()='Forgot your password? ']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    };

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkExist(){
        return driver.findElement(LINK_FORGOT_PASSWORD).isDisplayed();
    }

    public void enterUsername(String username){
        driver.findElement(USER_NAME).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }

    public DashboardPage doLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage(this.driver);
    }

}
