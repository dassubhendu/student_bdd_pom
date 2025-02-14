package stepdefinitions;

import com.pages.DashboardPage;
import com.pages.EmployeePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class EmployeePageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private DashboardPage dashboardPage;
    private EmployeePage employeePage;

    @Given("user successfully landed in employee page")
    public void user_successfully_landed_in_employee_page() throws InterruptedException {
        DriverFactory.getDriver().get(ConfigReader.initProp().getProperty("qa_url"));
        Thread.sleep(6000);
        dashboardPage = loginPage.doLogin(ConfigReader.initProp().getProperty("username"), ConfigReader.initProp().getProperty("password"));
        employeePage = dashboardPage.goToEmployeePage();
    }

    @Then("employee data icon is visible")
    public void employee_data_icon_is_visible() throws InterruptedException {
        Assert.assertTrue(employeePage.isEmployeeDataTextVisible());
    }
}
