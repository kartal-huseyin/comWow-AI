package stepdefinitions;

import homepage.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;

import java.io.IOException;

public class Hooks {

    @Before
    public static void before(Scenario scenario) {

    }
    @After
    public static void afterScenario(Scenario scenario) throws IOException {
        BaseTest.getScreenshot(scenario.getName());
    }
    @AfterAll
    public static void afterAll() {
        Driver.quitDriver();
    }

}
