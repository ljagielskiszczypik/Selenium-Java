package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


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
    public void setTravellers(int adultsToAdd, int childrenToAdd){
        searchHotelInputTravellers.click();
        for(int i =0; i<adultsToAdd;i++){
            searchHotelAdultPlusButton.click();
        }
        for(int i =0; i<childrenToAdd;i++){
            searchHotelChildrenPlusButton.click();
        }
    }
    public void clickSubmit(){
        searchHotelButtonSubmit.click();
    }

    public void assertNotFoundText(){
        Assert.assertEquals(searchHotelNotFound.getText(),"No Results Found");
    }
}
