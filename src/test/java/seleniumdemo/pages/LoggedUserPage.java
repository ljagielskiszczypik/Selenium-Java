package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoggedUserPage {
    public LoggedUserPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement SignUpheading;


    public void headingAssertion(WebDriver driver, Duration time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(SignUpheading));
        Assert.assertEquals(SignUpheading.getText(),"Hi, Łukasz Jagielski-Szczypik");
    }

    //        By headingLocator = By.xpath("//h3[@class='RTL']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));
//        WebElement heading = driver.findElement(headingLocator);
//        Assert.assertEquals(heading.getText(),"Hi, Łukasz Jagielski-Szczypik");
}
