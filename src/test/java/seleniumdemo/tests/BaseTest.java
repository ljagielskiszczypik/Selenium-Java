package seleniumdemo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import seleniumdemo.utils.DriverFactory;
import java.io.IOException;
public class BaseTest {
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extentReports;
    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        htmlReporter = new ExtentHtmlReporter("index.html");
        extentReports= new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }
    @AfterSuite
    public void afterSuite(){
        htmlReporter.flush();
        extentReports.flush();
    }
    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
