package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Driver;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepdefinitions"},
        tags = "",
        plugin = {"pretty", "html:test-output/cucumber-reports/Cucumber.html"}
)

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("CHROME") String browser) {
        Driver.getDriver();
    }

}
