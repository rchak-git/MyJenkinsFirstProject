package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
            File finalDestination = new File(destination);
            FileHandler.copy(source, finalDestination);
            return destination;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

