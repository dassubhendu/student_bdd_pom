package stepdefinitions;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.RosterMgmtPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RosterMgmtPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private DashboardPage dashboardPage;
    protected RosterMgmtPage rosterMgmtPage;

    @Given("User successfully login into roster management page")
    public void User_successfully_login_into_roster_management_page() throws InterruptedException {
        DriverFactory.getDriver().get(ConfigReader.initProp().getProperty("qa_url"));
        Thread.sleep(6000);
        dashboardPage = loginPage.doLogin(ConfigReader.initProp().getProperty("username"), ConfigReader.initProp().getProperty("password"));
        rosterMgmtPage = dashboardPage.goToRosterMgmtPage();
    }

    @Then("roster management icon is visible")
    public void roster_management_icon_is_visible() throws InterruptedException {
        Assert.assertTrue(rosterMgmtPage.isRosterMgmtTextVisible());
    }
}
