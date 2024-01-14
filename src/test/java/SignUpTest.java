import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SignUpTest {
    @Test
    public void signUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//nav//ul/li[@id='li_myaccount']")).click();
        driver.findElement(By.xpath("//li[@id='li_myaccount' and @class='open']/ul/li[1]/a")).click();

    }
}
