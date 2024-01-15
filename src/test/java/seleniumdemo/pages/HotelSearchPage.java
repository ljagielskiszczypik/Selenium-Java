package seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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

    public HotelSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setCity(String city){
        searchHotelSpan.click();
        searchHotelInput.sendKeys(city);
        searchHotelSpanDubai.click();
    }

    public void setDate(String checkIn, String checkOut){
        searchHotelInputDpd1.sendKeys(checkIn);
        searchHotelInputDpd2.sendKeys(checkOut);
    }
    public void setTravellers(){
        searchHotelInputTravellers.click();
        searchHotelAdultPlusButton.click();
        searchHotelChildrenPlusButton.click();
    }
    public void clickSubmit(){
        searchHotelButtonSubmit.click();
    }
}
