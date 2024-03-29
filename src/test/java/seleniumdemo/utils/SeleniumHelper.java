package seleniumdemo.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
public class SeleniumHelper {
    public static MediaEntityModelProvider getScreenshot(WebDriver driver) throws IOException {
        String path = takeScreenshot(driver);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }
    public static String takeScreenshot(WebDriver driver) throws IOException {
        int randomNumber = (int)(Math.random()*1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/sreenshot"+randomNumber+".png";
        FileHandler.copy(file,new File(path));
        return path;
    }
}
