package apphooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        prop = ConfigReader.initProp();
    }

    @Before(order = 1)
    public void launchBrowser() throws InterruptedException {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName);
        Thread.sleep(7000);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenShotName = scenario.getName().replaceAll("", "_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenShotName);
        }
    }

}
