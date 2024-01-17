package seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoggedUserPage {
    private static final Logger logger = LogManager.getLogger();
    public LoggedUserPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement SignUpheading;

    public void headingAssertion(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(SignUpheading));
        logger.info("starting assertion");
        Assert.assertEquals(SignUpheading.getText(),"Hi, Łukasz Jagielski-Szczypik");
        logger.info("assertion done");
    }
}
