package seleniumdemo.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import seleniumdemo.pages.HotelSearchPage;
import seleniumdemo.pages.ResultsPage;
import java.time.Duration;
public class HotelSearchTest extends BaseTest{
    @Test(priority = 0)
    public void searchHotelTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDate("01/02/2024","14/02/2024");
        hotelSearchPage.setTravellers(2,1);
        hotelSearchPage.clickSubmit();
        ResultsPage resultsPage = new ResultsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(resultsPage.hotelListWebElement));
        resultsPage.assertHotelNames();
    }
    @Test (priority = 1)
    public void searchHotelNotFoundTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDate("01/02/2024","14/02/2024");
        hotelSearchPage.setTravellers(2,1);
        hotelSearchPage.clickSubmit();
        hotelSearchPage.assertNotFoundText();
    }
}
