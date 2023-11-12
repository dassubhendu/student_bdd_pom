package stepdefinitions;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.java.Log;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DashboardPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private DashboardPage dashboardPage;

    @Given("user has already logged into application")
    public void user_has_already_logged_into_application(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> credList = dataTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        System.out.println("Username has been collected from datatable: " + username);
        System.out.println("Password has been collected from datatable: " + password);
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(6000);
        dashboardPage = loginPage.doLogin(username, password);
    }

    @Given("user is on dashboard page")
    public void user_is_on_dashboard_page() {
        dashboardPage.getDashboardPageTitle();
    }

    @Then("dashboard icon should be visible")
    public void dashboard_icon_should_be_visible() throws InterruptedException {
        Thread.sleep(6000);
        Assert.assertTrue(dashboardPage.isDashboardIconVisible());
    }

}
