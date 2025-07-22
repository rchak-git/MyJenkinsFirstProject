package automation.pages;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLElement;

import java.time.Duration;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        try {

           FluentWait<WebDriver>  wait = new FluentWait<>(driver)
                   .withTimeout(Duration.ofSeconds(10))
                   .pollingEvery(Duration.ofMillis(500))
                           .ignoring(NoSuchElementException.class);
           wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

            type(usernameField, username);
        }
        catch (Exception e)
        {
            logger.error("Error encountered in method: enterUserName + </br>" + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
      WebElement loginBtn =  wait.until(driver -> {
                  WebElement elem = driver.findElement(By.cssSelector("button[type='submit']"));
                  if (elem.isEnabled())
                      return elem;
                  else return null;
              });
       // click(loginButton);
        loginBtn.click();

    }

    public String getFlashMessage() {
        return getText(flashMessage);
    }
}
