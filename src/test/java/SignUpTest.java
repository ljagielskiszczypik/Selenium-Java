import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SignUpTest {
    @Test
    public void signUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//nav//ul/li[@id='li_myaccount']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        By signUp = By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUp));
        driver.findElement(signUp).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Łukasz");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Jagielski-Szczypik");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
        int randNumb =(int)(Math.random()* 1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lukas"+randNumb+"@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("haslo123");
        driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys("haslo123");
        driver.findElement(By.xpath("//form[@id='headersignupform']/div[@class='form-group']/button")).click();
        By headingLocator = By.xpath("//h3[@class='RTL']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));
        WebElement heading = driver.findElement(headingLocator);
        Assert.assertEquals(heading.getText(),"Hi, Łukasz Jagielski-Szczypik");
        driver.quit();
    }
    @Test
    public void signUpWithoutCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//nav//ul/li[@id='li_myaccount']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        By signUp = By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUp));
        driver.findElement(signUp).click();
        driver.findElement(By.xpath("//form[@id='headersignupform']/div[@class='form-group']/button")).click();
        By alertsLocator = By.xpath("//div[@id='login']//p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertsLocator));
        List<WebElement> alerts = driver.findElements(alertsLocator);
        Assert.assertEquals(alerts.get(0).getText(),"The Email field is required.");
        Assert.assertEquals(alerts.get(1).getText(),"The Password field is required.");
        Assert.assertEquals(alerts.get(2).getText(),"The Password field is required.");
        Assert.assertEquals(alerts.get(3).getText(),"The First name field is required.");
        Assert.assertEquals(alerts.get(4).getText(),"The Last Name field is required.");
        driver.quit();
    }

    @Test
    public void signUpWithIncorrectEmail(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//nav//ul/li[@id='li_myaccount']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        By signUp = By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUp));
        driver.findElement(signUp).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Łukasz");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Jagielski-Szczypik");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
        int randNumb =(int)(Math.random()* 1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lukas"+randNumb+".pl");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("haslo123");
        driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys("haslo123");
        driver.findElement(By.xpath("//form[@id='headersignupform']/div[@class='form-group']/button")).click();
        By alertLocator = By.xpath("//div[@id='login']//p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertLocator));
        WebElement alert = driver.findElement(alertLocator);
        Assert.assertEquals(alert.getText(),"The Email field must contain a valid email address.");
        driver.quit();
    }
}
