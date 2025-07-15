package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected WebDriver driver;
    protected static final Logger baseLogger = LogManager.getLogger(BasePage.class);
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Common actions
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        baseLogger.info("Entering value for Field locator:" + locator.toString());
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        baseLogger.info ("Entered value : " + text);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
}
