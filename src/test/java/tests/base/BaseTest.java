package tests.base;
import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static Utils.ExtentReportSetup.setupExtentReport;

public class BaseTest {
    protected WebDriver driver;
   protected ExtentReports extentReports = setupExtentReport();

    @BeforeClass
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        extentReports.flush();
    }
}
