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

public class HotelSearchPage {
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;
    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement searchHotelInput;
    @FindBy(xpath = "//div[@id='select2-drop']//span[text()='Dubai']")
    private WebElement searchHotelSpanDubai;
    @FindBy(xpath = "//div[@id='dpd1']/div/input")
    private WebElement searchHotelInputDpd1;
    @FindBy(xpath = "//div[@id='dpd2']/div/input")
    private WebElement searchHotelInputDpd2;
    @FindBy(xpath = "//input[@id='travellersInput']")
    private WebElement searchHotelInputTravellers;
    @FindBy(xpath = "//button[@id='adultPlusBtn']")
    private WebElement searchHotelAdultPlusButton;
    @FindBy(xpath = "//button[@id='childPlusBtn']")
    private WebElement searchHotelChildrenPlusButton;
    @FindBy(xpath = "//div[@id='hotels']//button[@type='submit']")
    private WebElement searchHotelButtonSubmit;
    @FindBy(xpath = "//h2")
    private WebElement searchHotelNotFound;
    @FindBy(xpath = "//nav//ul/li[@id='li_myaccount']")
    private WebElement searchHotelMyAccount;
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a")
    private WebElement searchHotelSignUp;

    public HotelSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private static final Logger logger = LogManager.getLogger();

    public void setCity(String city, WebDriver driver){
        logger.info("setting city: " + city);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(city);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(searchHotelSpanDubai));
        searchHotelSpanDubai.click();
        logger.info("setting city done");
    }
    public void setDate(String checkIn, String checkOut){
        logger.info("setting check in date");
        searchHotelInputDpd1.sendKeys(checkIn);
        logger.info("setting check in date done");
        logger.info("setting check out date");
        searchHotelInputDpd2.sendKeys(checkOut);
        logger.info("setting check out date done");
    }
    public void setTravellers(int adultsToAdd, int childrenToAdd){
        searchHotelInputTravellers.click();
        for(int i =0; i<adultsToAdd;i++){
            logger.info("adding adult");
            searchHotelAdultPlusButton.click();
            logger.info("addind adult done");
        }
        for(int i =0; i<childrenToAdd;i++){
            logger.info("adding children");
            searchHotelChildrenPlusButton.click();
            logger.info("adding done");
        }
    }
    public void clickSubmit(){
        logger.info("clicking submit button");
        searchHotelButtonSubmit.click();
        logger.info("clicking submit button done");
    }
    public void assertNotFoundText(){
        logger.info("starting assertion");
        Assert.assertEquals(searchHotelNotFound.getText(),"No Results Found");
        logger.info("assertion done");
    }
    public void clickSignUp(WebDriver driver){
        logger.info("clicking My account");
        searchHotelMyAccount.click();
        logger.info("clicking My account done");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchHotelSignUp));
        logger.info("clicking sign up");
        searchHotelSignUp.click();
        logger.info("clicking sign up done");
    }
}
