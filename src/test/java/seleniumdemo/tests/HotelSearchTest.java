package seleniumdemo.tests;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import seleniumdemo.pages.HotelSearchPage;
import seleniumdemo.pages.ResultsPage;
import seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;

public class HotelSearchTest extends BaseTest{
    @Test(priority = 0)
    public void searchHotelTest() throws IOException {
        ExtentTest test = extentReports.createTest("Search Hotel Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai", driver);
        test.log(Status.PASS,"Setting city done",SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setDate("01/02/2024","14/02/2024");
        test.log(Status.PASS,"Setting dates done",SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setTravellers(2,1);
        test.log(Status.PASS,"Setting travellers done",SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.clickSubmit();
        test.log(Status.PASS,"Performing search done",SeleniumHelper.getScreenshot(driver));
        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.assertHotelNames(driver);
        test.log(Status.PASS,"Assertions passed",SeleniumHelper.getScreenshot(driver));

    }
    @Test (priority = 1)
    public void searchHotelNotFoundTest() throws IOException {
        ExtentTest test = extentReports.createTest("Search Hotel without setting city Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDate("01/02/2024","14/02/2024");
        test.log(Status.PASS,"Setting dates done",SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setTravellers(2,1);
        test.log(Status.PASS,"Setting travellers done",SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.clickSubmit();
        test.log(Status.PASS,"Performing search done",SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.assertNotFoundText();
        test.log(Status.PASS,"Assertions passed",SeleniumHelper.getScreenshot(driver));
    }
}
