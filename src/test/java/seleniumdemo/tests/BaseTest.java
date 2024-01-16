package seleniumdemo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import seleniumdemo.utils.DriverFactory;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.getDriver("chrome");
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
