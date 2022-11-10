package homepage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.Waits;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void sendKeys(By locator, CharSequence... keysToSend) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(keysToSend);
    }
    public void sendKeys(WebElement element, CharSequence... keysToSend){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keysToSend);
    }

    public void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }


    public void waitForElement(By locator, Waits wait) {
        switch (wait) {
            case CLICKABLE -> this.wait.until(ExpectedConditions.elementToBeClickable(locator));
            case VISIBILITY -> this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            default -> this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }

    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)",element);

    }
    public void scrollIntoView(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(locator));

    }

    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollBy(int val) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + val + ")");
    }

    public static void getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String target = System.getProperty("user.dir") + "/test-output/screenshots/" + name + date + ".png";
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, file);
    }

    public void switchHandle(){
        String currentHandle=driver.getWindowHandle();
        Set<String> handles=Driver.getDriver().getWindowHandles();
        String secondHandle=null;
        for (String each:handles) {
            if (!each.equals(currentHandle)){
                secondHandle=each;
            }
        }
        driver.switchTo().window(secondHandle);
    }



}
