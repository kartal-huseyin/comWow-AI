package stepdefinitions;

import com.github.javafaker.Faker;
import homepage.BaseTest;
import homepage.Locators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Waits;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepDefs extends BaseTest implements Locators {

    //Homepage Feature Steps
    @Given("user on TestPage")
    public void userOnTestPage() {
        driver.get(url);
    }

    @Given("click on logo button")
    public void click_on_logo_button() {
        driver.findElement(logo).click();
    }

    @Then("verify homepage")
    public void verify_homepage() {
        String expectedTitle = "A global provider of high-quality AI training data";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @And("click on address")
    public void clickOnAddress() {
        click(location);
    }

    @Then("click on contactMail")
    public void clickOnContactMail() {
        click(contactMail);
    }

    @And("click on flags")
    public void clickOnFlags() throws IOException {
        List<String> title = new ArrayList<>() {{
            add("en");
            add("ja");
            add("pt");
            add("es");
        }};

        int index=0;
        for (WebElement e : driver.findElements(flags)) {
            click(e);
            By flagTitle = By.xpath("//html[@lang=\"" + title.get(index) + "\"]");
            System.out.println(flagTitle);
            waitForElement(flagTitle,Waits.VISIBILITY);
            Assert.assertTrue(driver.findElement(flagTitle).isDisplayed());
            index++;
        }
    }

    @And("user goes to Contact page")
    public void userGoesToContactPage() {
        click(contactUs);
    }

    @And("fill out form")
    public void fillOutForm() {
        Faker faker = new Faker();
        //valid credentials check
        sendKeys(firstNameInput, faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                faker.phoneNumber().toString(),
                Keys.TAB,
                faker.company().toString(),
                Keys.TAB,
                faker.lorem().paragraph());
    }

    @Then("submit the form")
    public void submitTheForm() {
        click(submitButton);
    }

    @Then("verify form sent")
    public void verifyFormSent() {
        String expectedMesseage = "Your message was sent successfully. Thanks.";
        String actualMessage = driver.findElement(message).getText();
        Assert.assertEquals(actualMessage, expectedMesseage, "The message couldn't send.");
    }

    @Then("scroll down")
    public void scrollDown() {
        click(scrollDown);
    }

    @And("click on video")
    public void clickOnVideo() throws InterruptedException {
        click(video);
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
    }

    //Contact Feature Steps
    @When("user fill the form as follow")
    public void userFillTheFormAsFollow(DataTable table) {
        Map<String, String> map = table.asMap();

        //NOTE: since empty datas are seen as "null", datas are converted to blank
        String val = map.get("firstName") != null ? map.get("firstName") : "";
        sendKeys(By.id("first_name"), val);

        val = map.get("lastName") != null ? map.get("lastName") : "";
        sendKeys(By.id("last_name"), val);

        val = map.get("email") != null ? map.get("email") : "";
        sendKeys(By.id("email"), val);

        val = map.get("telephone") != null ? map.get("telephone") : "";
        sendKeys(By.id("phone"), val);

        val = map.get("company") != null ? map.get("company") : "";
        sendKeys(By.id("company"), val);

        val = map.get("comments") != null ? map.get("comments") : "";
        sendKeys(By.id("comments"), val);

        click(By.id("form_submit"));
    }

    @Then("submit should be {int}")
    public void submitShouldBe(int errorFileds) {
        List<WebElement> errors = driver.findElements(By.cssSelector("label.error"));
        int visibleLabels = errors.stream().filter(e -> e.isDisplayed()).toList().size();
        if (errorFileds > 0) {
            Assert.assertEquals(visibleLabels, errorFileds, "The form should not be submitted.");
        }
    }


    //Event Feature Steps
    @When("user goes to event")
    public void userGoesToEvent() {
        click(event);
    }

    @And("user fills out the apply form")
    public void userFillsOutTheApplyForm() {
        switchHandle();
        waitForElement(applyForm,Waits.EXISTS);
        scrollIntoView(applyForm);
        waitFor(1);
        switchHandle();
        waitFor(2);
        scrollIntoView(applyForm);
        driver.switchTo().frame(0);
        Faker faker=new Faker();
        sendKeys(applyNameInput,
                faker.name().firstName(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                faker.job().toString(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                faker.company().toString(),
                Keys.TAB,
                faker.lorem().paragraph(),
                Keys.TAB,
                Keys.ENTER);

        waitForElement(registered,Waits.VISIBILITY);

        Assert.assertTrue(driver.findElement(registered).isDisplayed());
    }
}
