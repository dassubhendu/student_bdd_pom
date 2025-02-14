package stepdefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Properties;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        DriverFactory.getDriver().get(ConfigReader.initProp().getProperty("qa_url"));
        Thread.sleep(7000);
    }

    @When("user enters username")
    public void user_enters_username() {
        loginPage.enterUsername(ConfigReader.initProp().getProperty("username"));
    }

    @When("user enters wrong username")
    public void user_enters_wrong_username() {
        loginPage.enterUsername(ConfigReader.initProp().getProperty("wrong_username"));
    }

    @When("user enters password")
    public void user_enters_password() {
       loginPage.enterPassword(ConfigReader.initProp().getProperty("password"));
    }

    @When("user enters wrong password")
    public void user_enters_wrong_password() {
        loginPage.enterPassword(ConfigReader.initProp().getProperty("wrong_password"));
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @Then("desired page URL should be displayed")
    public void desired_page_url_should_be_displayed() throws InterruptedException {
        Assert.assertTrue(loginPage.verifyValidInvalidLoginWithURL(ConfigReader.initProp().getProperty("qa_dashboard_page_url")));
    }

    @Then("desired page URL should be displayed for unsuccessful login")
    public void desired_page_url_should_be_displayed_for_unsuccessful_login() throws InterruptedException {
        Assert.assertTrue(loginPage.verifyValidInvalidLoginWithURL(ConfigReader.initProp().getProperty("qa_url")));
    }

}
