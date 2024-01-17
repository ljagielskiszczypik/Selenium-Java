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
import java.util.List;
public class ResultsPage {
    private static final Logger logger = LogManager.getLogger();
    @FindBy(xpath = "//h4/a/b")
    public WebElement hotelListWebElement;
    @FindBy(xpath = "//h4/a/b")
    public List<WebElement> hotelList;
    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void assertHotelNames(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(hotelList));
        for(WebElement hotel: hotelList){
            System.out.println(hotel.getText());
        }
        logger.info("starting assertion");
        Assert.assertEquals(hotelList.get(0).getText(),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelList.get(1).getText(),"Oasis Beach Tower");
        Assert.assertEquals(hotelList.get(2).getText(),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelList.get(3).getText(),"Hyatt Regency Perth");
        logger.info("assertion done");
    }
}
