package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures/"},
        glue = {"stepdefinitions", "apphooks"},
        tags = "@Regression",
        plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class MyTestRunner1 {
}
