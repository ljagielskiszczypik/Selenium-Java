package seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.pages.HotelSearchPage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HotelSearchTest extends BaseTest{
    @Test(priority = 0)
    public void searchHotelTest(){

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDate("01/02/2024","14/02/2024");
        hotelSearchPage.setTravellers();
        hotelSearchPage.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By hotelNamesLocator = By.xpath("//h4/a/b");
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotelNamesLocator));
        List<WebElement> hotelNames = driver.findElements(hotelNamesLocator);
        for(WebElement name: hotelNames){
            System.out.println(name.getText());
        }
        Assert.assertEquals(hotelNames.get(0).getText(),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1).getText(),"Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2).getText(),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3).getText(),"Hyatt Regency Perth");
    }

    @Test ()
    public void searchHotelNotFoundTest(){
        driver.findElement(By.xpath("//div[@id='dpd1']/div/input")).sendKeys("01/02/2024");
        driver.findElement(By.xpath("//div[@id='dpd2']/div/input")).sendKeys("14/02/2024");
        driver.findElement(By.xpath("//input[@id='travellersInput']")).click();
        driver.findElement(By.xpath("//button[@id='adultPlusBtn']")).click();
        driver.findElement(By.xpath("//button[@id='childPlusBtn']")).click();
        driver.findElement(By.xpath("//div[@id='hotels']//button[@type='submit']")).click();
        WebElement notFoundText = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(notFoundText.getText(),"No Results Found");
    }
}
