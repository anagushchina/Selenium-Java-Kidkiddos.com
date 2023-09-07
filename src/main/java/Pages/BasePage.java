package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class);


    public void setWebDriver(WebDriver webDriver){
        this.webDriver=webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    protected WebElement findElementByXpath(String xPath){
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        element = webDriver.findElement(By.xpath(xPath));
        return element;
    }

    protected void clickElementByXpath(String xPath){
        logger.info("Clicking element " + xPath);
        findElementByXpath(xPath).click();
    }

    protected void sendTextToElementByXpath(String xPath, String text){
        logger.info(String.format("Sending text '%s' to element located by: %s", text, xPath));
        findElementByXpath(xPath).clear();
        findElementByXpath(xPath).sendKeys(text);
    }

    protected boolean isElementExists(String xPath){
        try{
            logger.info(String.format("Checking if element located by: %s exists", xPath));
            findElementByXpath(xPath);
            return true;
        }
        catch (Exception err){
            return false;
        }
    }

    protected boolean isElementVisible(String xPath){
        try{
            logger.info(String.format("Checking if element located by: %s is visible", xPath));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            return true;
        }
        catch (Exception err){
            return false;
        }
    }

    protected String getElementValue(String xPath){
        logger.info("Getting value from the element: " + xPath);
        String elementValue = findElementByXpath(xPath).getAttribute("value");
        return elementValue;
    }

    protected String getElementText(String xPath){
        logger.info("Getting text from the element: " + xPath);
        String elementText = findElementByXpath(xPath).getText();
        return elementText;
    }

    public void takeScreenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollDownPage(){
        logger.info("Scrolling down the page");
        new Actions(webDriver)
                .scrollByAmount(0, 1000)
                .perform();
    }

    protected String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }

}
