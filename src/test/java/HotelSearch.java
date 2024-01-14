import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class HotelSearch {
    @Test
    public void searchHotel(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//div[@id='select2-drop']//span[text()='Dubai']")).click();
        driver.findElement(By.xpath("//div[@id='dpd1']/div/input")).sendKeys("01/02/2024");
        driver.findElement(By.xpath("//div[@id='dpd2']/div/input")).sendKeys("14/02/2024");
        driver.findElement(By.xpath("//input[@id='travellersInput']")).click();
        driver.findElement(By.xpath("//button[@id='adultPlusBtn']")).click();
        driver.findElement(By.xpath("//button[@id='childPlusBtn']")).click();
    }
}
