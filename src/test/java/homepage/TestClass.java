package homepage;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waits;

public class TestClass extends BaseTest implements Locators {


    //for testVideo() method; pls kindly change BaseTest constructor browser to FIREFOX
    @Test
    public void testVideo() {
        driver.get(url);
        waitFor(1);
        click(scrollDown);
        waitFor(1);
        click(video);
        click(video);
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
        waitFor(1);
    }

    @Test
    public void testEvent(){
        driver.get(url);
        click(event);
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
