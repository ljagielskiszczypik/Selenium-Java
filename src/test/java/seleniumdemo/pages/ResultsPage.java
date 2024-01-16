package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;
public class ResultsPage {
    @FindBy(xpath = "//h4/a/b")
    public WebElement hotelListWebElement;
    @FindBy(xpath = "//h4/a/b")
    public List<WebElement> hotelList;
    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void assertHotelNames(){
        for(WebElement hotel: hotelList){
            System.out.println(hotel.getText());
        }
        Assert.assertEquals(hotelList.get(0).getText(),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelList.get(1).getText(),"Oasis Beach Tower");
        Assert.assertEquals(hotelList.get(2).getText(),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelList.get(3).getText(),"Hyatt Regency Perth");
    }
}
